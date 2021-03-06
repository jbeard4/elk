/*******************************************************************************
 * Copyright (c) 2009, 2015 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Kiel University - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.alg.graphviz.layouter.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * An output stream that can be used to send the same output to multiple output streams.
 * 
 * @author msp
 */
public class ForkedOutputStream extends OutputStream {

    /** the list of output streams to which this stream will write. */
    private final List<OutputStream> outputStreams;
    
    /**
     * Creates a forked output stream that writes to all output streams in the given list.
     * 
     * @param theoutputStreams list of output streams
     */
    public ForkedOutputStream(final List<OutputStream> theoutputStreams) {
        this.outputStreams = theoutputStreams;
    }
    
    /**
     * Creates a forked output stream that writes to all given output streams.
     * 
     * @param streams an array of output streams
     */
    public ForkedOutputStream(final OutputStream... streams) {
        this.outputStreams = Arrays.asList(streams);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void write(final int b) throws IOException {
        for (OutputStream stream : outputStreams) {
            stream.write(b);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void flush() throws IOException {
        for (OutputStream stream : outputStreams) {
            stream.flush();
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws IOException {
        for (OutputStream stream : outputStreams) {
            stream.close();
        }
    }

}
