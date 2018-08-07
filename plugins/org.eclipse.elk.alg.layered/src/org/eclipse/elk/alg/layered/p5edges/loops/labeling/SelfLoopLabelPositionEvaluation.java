/*******************************************************************************
 * Copyright (c) 2018 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.elk.alg.layered.p5edges.loops.labeling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.elk.alg.layered.graph.LNode;
import org.eclipse.elk.alg.layered.p5edges.loops.SelfLoopComponent;
import org.eclipse.elk.alg.layered.p5edges.loops.SelfLoopLabel;
import org.eclipse.elk.alg.layered.p5edges.loops.SelfLoopNode;
import org.eclipse.elk.alg.layered.p5edges.loops.SelfLoopPort;
import org.eclipse.elk.alg.layered.p5edges.loops.calculators.SelfLoopOffsetCalculator;
import org.eclipse.elk.alg.layered.p5edges.splines.SplinesMath;
import org.eclipse.elk.core.math.ElkMath;
import org.eclipse.elk.core.math.ElkRectangle;
import org.eclipse.elk.core.math.KVector;
import org.eclipse.elk.core.options.PortSide;

/**
 * Choose a candidate position for each component label.
 */
public final class SelfLoopLabelPositionEvaluation {
    
    
    private static final double EDGE_DISTANCE = 10;
    /** Penalty applied for label-edge crossings. */
    private static final double LABEL_EDGE_CROSSING_PENALTY = 10.0;
    /** Penalty applied for label-label crossings. */
    private static final double LABEL_LABEL_CROSSING_PENALTY = 40.0;
    /** Penalty applied for label-node crossings. */
    private static final double LABEL_NODE_CROSSING = 100.0;

    
    /**
     * No instantiation.
     */
    private SelfLoopLabelPositionEvaluation() {
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Position Evaluation
    
    /**
     * 
     */
    public static List<SelfLoopLabel> evaluatePositions(final SelfLoopNode slNode,
            final Map<SelfLoopComponent, List<SelfLoopLabelPosition>> positionsComponentMap) {

        // initialize a random position constellation
        HashMap<SelfLoopComponent, SelfLoopLabelPosition> minimumConstellation =
                initializeConstellation(positionsComponentMap);

        // calculate the current penalty value
        double minimumPenalty = calculatePenalty(slNode, positionsComponentMap);
        double previousPenalty = Double.MAX_VALUE;

        while (minimumPenalty < previousPenalty) {
            previousPenalty = minimumPenalty;
            double currentMinimum = Double.MAX_VALUE;
            HashMap<SelfLoopComponent, SelfLoopLabelPosition> currentMinimumConstellation =
                    new HashMap<>(minimumConstellation);

            for (SelfLoopComponent component : positionsComponentMap.keySet()) {
                List<SelfLoopLabelPosition> positions = positionsComponentMap.get(component);

                // search for the minimum of each component
                for (int i = 0; i < positions.size(); i++) {
                    SelfLoopLabelPosition currentPosition = positions.get(i);
                    component.getLabel().setRelativeLabelPosition(currentPosition);
                    currentMinimumConstellation.put(component, currentPosition);

                    // calculate penalty for current constellation
                    currentMinimum = calculatePenalty(slNode, positionsComponentMap);

                    // update minimum
                    if (currentMinimum < minimumPenalty) {
                        minimumPenalty = currentMinimum;
                        minimumConstellation = new HashMap<>(currentMinimumConstellation);
                    }
                }

                component.getLabel().setRelativeLabelPosition(minimumConstellation.get(component));
            }
        }

        // collect labels
        List<SelfLoopLabel> labels = new ArrayList<>();
        for (SelfLoopComponent components : positionsComponentMap.keySet()) {
            labels.add(components.getLabel());
        }
        
        return labels;
    }

    private static HashMap<SelfLoopComponent, SelfLoopLabelPosition> initializeConstellation(
            final Map<SelfLoopComponent, List<SelfLoopLabelPosition>> positionsComponentMap) {

        HashMap<SelfLoopComponent, SelfLoopLabelPosition> minimumConstellation = new HashMap<>();
        
        for (SelfLoopComponent component : positionsComponentMap.keySet()) {
            // take a "random" position from the components candidate positions
            List<SelfLoopLabelPosition> componentPositions = positionsComponentMap.get(component);
            SelfLoopLabelPosition currentPosition = componentPositions.get(0);
            component.getLabel().setRelativeLabelPosition(currentPosition);
            minimumConstellation.put(component, currentPosition);
        }
        
        return minimumConstellation;
    }

    private static double calculatePenalty(final SelfLoopNode nodeRep,
            final Map<SelfLoopComponent, List<SelfLoopLabelPosition>> positionsComponentMap) {

        double preferenceValueSum = 0;
        
        // reset the previous calculated offsets
        for (SelfLoopComponent component : positionsComponentMap.keySet()) {
            SelfLoopLabelPosition position = component.getLabel().getRelativeLabelPosition();
            position.resetPosition();
            preferenceValueSum += position.getPenalty();
        }

        // offset port heights and opposing segment heights
        SelfLoopOffsetCalculator.calculatePortLabelOffsets(nodeRep);
        SelfLoopOffsetCalculator.calculateOpposingSegmentLabelOffsets(nodeRep);

        // calculate the different penalties
        double labelNodeCrossing = calculateLabelNodeCrossings(nodeRep.getNode(), positionsComponentMap.keySet());
        double labelLabelCrossings = calculateLabelLabelCrossings(positionsComponentMap.keySet());
        double labelEdgeCrossings = calculateLabelEdgeCrossings(nodeRep, positionsComponentMap.keySet());
        
        return LABEL_EDGE_CROSSING_PENALTY * labelEdgeCrossings
                + LABEL_LABEL_CROSSING_PENALTY * labelLabelCrossings
                + preferenceValueSum
                + LABEL_NODE_CROSSING * labelNodeCrossing;
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Crossing Calculation

    private static int calculateLabelNodeCrossings(final LNode lNode, final Set<SelfLoopComponent> components) {
        KVector nodePosition = lNode.getPosition();
        KVector size = lNode.getSize();
        ElkRectangle rectangle = new ElkRectangle(nodePosition.x, nodePosition.y, size.x, size.y);

        int crossings = 0;
        for (SelfLoopComponent component : components) {
            SelfLoopLabel label = component.getLabel();
            SelfLoopLabelPosition currentPosition = label.getRelativeLabelPosition();
            KVector currentPosVector = currentPosition.getPosition().clone();

            boolean topSideCut = ElkMath.intersects(rectangle, currentPosVector,
                    currentPosVector.add(new KVector(currentPosVector.x, 0)));

            boolean topSideInclude = ElkMath.contains(rectangle, currentPosVector,
                    currentPosVector.add(new KVector(currentPosVector.x, 0)));

            boolean bottomSideCut = ElkMath.intersects(rectangle, currentPosVector.add(0, currentPosVector.y),
                    currentPosVector.add(new KVector(currentPosVector.x, currentPosVector.y)));

            boolean bottomSideInclude = ElkMath.contains(rectangle, currentPosVector.add(0, currentPosVector.y),
                    currentPosVector.add(new KVector(currentPosVector.x, currentPosVector.y)));

            boolean leftSideCut = ElkMath.intersects(rectangle, currentPosVector,
                    currentPosVector.add(new KVector(0, currentPosVector.y)));

            boolean leftSideInclude = ElkMath.contains(rectangle, currentPosVector,
                    currentPosVector.add(new KVector(0, currentPosVector.y)));

            boolean rightSideCut = ElkMath.intersects(rectangle, currentPosVector.add(currentPosVector.x, 0),
                    currentPosVector.add(new KVector(currentPosVector.x, currentPosVector.y)));

            boolean rightSideInclude = ElkMath.contains(rectangle, currentPosVector.add(currentPosVector.x, 0),
                    currentPosVector.add(new KVector(currentPosVector.x, currentPosVector.y)));

            if (topSideCut || topSideInclude || bottomSideCut || bottomSideInclude || leftSideCut || leftSideInclude
                    || rightSideCut || rightSideInclude) {
                
                crossings++;
            }
        }
        return crossings;
    }

    private static int calculateLabelLabelCrossings(final Set<SelfLoopComponent> components) {
        // receive all candidate positions
        Set<SelfLoopComponent> nonVisitedComponents = new HashSet<>(components);
        int labelLabelCrossings = 0;

        // label-label crossings
        for (SelfLoopComponent component : components) {
            nonVisitedComponents.remove(component);
            for (SelfLoopComponent nextPos : nonVisitedComponents) {
                SelfLoopLabel firstLabel = component.getLabel();
                SelfLoopLabelPosition firstPosition = firstLabel.getRelativeLabelPosition();
                KVector firstPositionVector = firstPosition.getPosition();

                SelfLoopLabel secondLabel = nextPos.getLabel();
                SelfLoopLabelPosition secondPosition = secondLabel.getRelativeLabelPosition();
                KVector secondPositionVector = secondPosition.getPosition();

                if ((firstPositionVector.x <= secondPositionVector.x
                        && secondPositionVector.x < firstPositionVector.x + firstLabel.getWidth())
                        || (secondPositionVector.x <= firstPositionVector.x
                                && firstPositionVector.x < secondPositionVector.x + secondLabel.getWidth())) {

                    if ((firstPositionVector.y <= secondPositionVector.y
                            && secondPositionVector.y < firstPositionVector.y + firstLabel.getHeight())
                            || (secondPositionVector.y <= firstPositionVector.y
                                    && firstPositionVector.y < secondPositionVector.y + secondLabel.getHeight())) {
                        labelLabelCrossings++;
                    }
                }

            }

        }
        return labelLabelCrossings;
    }

    private static int calculateLabelEdgeCrossings(final SelfLoopNode nodeRep,
            final Set<SelfLoopComponent> components) {
        
        int labelEdgeCrossings = 0;
        for (SelfLoopComponent component : components) {
            SelfLoopLabel label = component.getLabel();
            SelfLoopLabelPosition currentPosition = label.getRelativeLabelPosition();
            KVector currentPosVector = currentPosition.getPosition();
            PortSide positionSide = currentPosition.getSide();

            // calculate if an edge starting at the same side would cross the label position
            for (SelfLoopPort port : nodeRep.getNodeSide(positionSide).getPorts()) {
                boolean portCrossing = isCrossing(port, currentPosVector, label, positionSide);
                if (portCrossing) {
                    currentPosition.setLabelEdgeCrossings(currentPosition.getLabelEdgeCrossings() + 1);
                    labelEdgeCrossings++;
                }
            }
        }
        return labelEdgeCrossings;
    }

    private static boolean isCrossing(final SelfLoopPort port, final KVector currentPosition, final SelfLoopLabel label,
            final PortSide side) {
        
        KVector portPosition = port.getLPort().getPosition();
        double offset = port.getOtherEdgeOffset();
        double direction = SplinesMath.portSideToDirection(side);

        KVector sourcePos = portPosition.clone().add(port.getLPort().getAnchor());

        int sourceLevel = port.getMaximumLevel();
        double otherEdgeOffset = port.getOtherEdgeOffset();

        // calculate the two bend points
        KVector portBendPoint = sourcePos.clone().add(new KVector(direction).scale(sourceLevel * EDGE_DISTANCE));
        portBendPoint.add(new KVector(direction).scale(otherEdgeOffset));

        double width = label.getWidth();
        double height = label.getHeight();
        double labelWidthPoint = currentPosition.x + width;
        double labelHeightPoint = currentPosition.y + height;

        if (side == PortSide.NORTH || side == PortSide.SOUTH) {
            // TODO find fuzzy compare DoubleMath.fuzzyCompare(a, b, tolerance)
            if (currentPosition.x <= portPosition.x && portPosition.x <= labelWidthPoint) {
                if (labelHeightPoint > portBendPoint.y) {
                    return true;
                }
            }
            
        } else {
            if (currentPosition.y <= portPosition.y && portPosition.y <= labelHeightPoint) {
                if (labelWidthPoint < portBendPoint.x || offset == 0) {
                    return true;
                }
            }
        }
        
        return false;
    }

}