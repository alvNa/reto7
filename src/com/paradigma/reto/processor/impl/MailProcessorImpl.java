package com.paradigma.reto.processor.impl;

import com.paradigma.reto.processor.AbstractProcessor;
import com.paradigma.reto.util.Utils;


/**
 * Mail Processor implementation. 
 * This class process files with mails and store the mails
 * in a structure.
 * 
 * @author Álvaro Navarro
 */
public class MailProcessorImpl extends AbstractProcessor
{
    /**
     * Constructor
     * @param sorted
     */
    public MailProcessorImpl(boolean sorted)
    {
        super(sorted);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public String processElement(String line)
    {
        return Utils.processMail(line);
    }
}
