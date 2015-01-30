package com.paradigma.reto.processor.impl;

import com.paradigma.reto.processor.AbstractProcessor;
import com.paradigma.reto.util.Utils;


/**
 * User Processor implementation. 
 * This class process files with users and store the users
 * in a structure.
 * 
 * @author Álvaro Navarro
 */
public class UserProcessorImpl extends AbstractProcessor
{
    /**
     * Constructor
     * @param sorted
     */
    public UserProcessorImpl(boolean sorted)
    {
        super(sorted);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public String processElement(String line)
    {
        return Utils.processName(line);
    }
}
