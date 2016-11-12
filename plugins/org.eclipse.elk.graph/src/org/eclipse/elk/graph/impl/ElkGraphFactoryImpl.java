/**
 * Copyright (c) 2016 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Kiel University - initial API and implementation
 */
package org.eclipse.elk.graph.impl;

import java.util.Map;

import org.eclipse.elk.graph.*;

import org.eclipse.elk.graph.properties.IProperty;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ElkGraphFactoryImpl extends EFactoryImpl implements ElkGraphFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ElkGraphFactory init() {
        try {
            ElkGraphFactory theElkGraphFactory = (ElkGraphFactory)EPackage.Registry.INSTANCE.getEFactory(ElkGraphPackage.eNS_URI);
            if (theElkGraphFactory != null) {
                return theElkGraphFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ElkGraphFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkGraphFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case ElkGraphPackage.EMAP_PROPERTY_HOLDER: return createEMapPropertyHolder();
            case ElkGraphPackage.ELK_GRAPH_ELEMENT: return createElkGraphElement();
            case ElkGraphPackage.ELK_SHAPE: return createElkShape();
            case ElkGraphPackage.ELK_LABEL: return createElkLabel();
            case ElkGraphPackage.ELK_CONNECTABLE_SHAPE: return createElkConnectableShape();
            case ElkGraphPackage.ELK_NODE: return createElkNode();
            case ElkGraphPackage.ELK_PORT: return createElkPort();
            case ElkGraphPackage.ELK_EDGE: return createElkEdge();
            case ElkGraphPackage.ELK_BEND_POINT: return createElkBendPoint();
            case ElkGraphPackage.ELK_EDGE_SECTION: return createElkEdgeSection();
            case ElkGraphPackage.ELK_PROPERTY_TO_VALUE_MAP_ENTRY: return (EObject)createElkPropertyToValueMapEntry();
            case ElkGraphPackage.ELK_PERSISTENT_ENTRY: return createElkPersistentEntry();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case ElkGraphPackage.IPROPERTY:
                return createIPropertyFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case ElkGraphPackage.IPROPERTY:
                return convertIPropertyToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMapPropertyHolder createEMapPropertyHolder() {
        EMapPropertyHolderImpl eMapPropertyHolder = new EMapPropertyHolderImpl();
        return eMapPropertyHolder;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkGraphElement createElkGraphElement() {
        ElkGraphElementImpl elkGraphElement = new ElkGraphElementImpl();
        return elkGraphElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkShape createElkShape() {
        ElkShapeImpl elkShape = new ElkShapeImpl();
        return elkShape;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkLabel createElkLabel() {
        ElkLabelImpl elkLabel = new ElkLabelImpl();
        return elkLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkConnectableShape createElkConnectableShape() {
        ElkConnectableShapeImpl elkConnectableShape = new ElkConnectableShapeImpl();
        return elkConnectableShape;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkNode createElkNode() {
        ElkNodeImpl elkNode = new ElkNodeImpl();
        return elkNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkPort createElkPort() {
        ElkPortImpl elkPort = new ElkPortImpl();
        return elkPort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkEdge createElkEdge() {
        ElkEdgeImpl elkEdge = new ElkEdgeImpl();
        return elkEdge;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkBendPoint createElkBendPoint() {
        ElkBendPointImpl elkBendPoint = new ElkBendPointImpl();
        return elkBendPoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkEdgeSection createElkEdgeSection() {
        ElkEdgeSectionImpl elkEdgeSection = new ElkEdgeSectionImpl();
        return elkEdgeSection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Map.Entry<IProperty<?>, Object> createElkPropertyToValueMapEntry() {
        ElkPropertyToValueMapEntryImpl elkPropertyToValueMapEntry = new ElkPropertyToValueMapEntryImpl();
        return elkPropertyToValueMapEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkPersistentEntry createElkPersistentEntry() {
        ElkPersistentEntryImpl elkPersistentEntry = new ElkPersistentEntryImpl();
        return elkPersistentEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IProperty<?> createIPropertyFromString(EDataType eDataType, String initialValue) {
        return (IProperty<?>)super.createFromString(initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertIPropertyToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ElkGraphPackage getElkGraphPackage() {
        return (ElkGraphPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ElkGraphPackage getPackage() {
        return ElkGraphPackage.eINSTANCE;
    }

} //ElkGraphFactoryImpl