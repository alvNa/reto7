package com.paradigma.reto.impl;

import com.paradigma.reto.RetoJava7;
import com.paradigma.reto.constant.Constants;
import com.paradigma.reto.processor.AbstractProcessor;
import com.paradigma.reto.processor.impl.MailProcessorImpl;
import com.paradigma.reto.processor.impl.UserProcessorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Implementation of the proposed problem.
 * @author Álvaro Navarro
 */
public class RetoJava7Impl implements RetoJava7
{
    /**
     * User processor
     */
    private AbstractProcessor userProcessor;

    /**
     * Mail processor
     */
    private AbstractProcessor mailProcessor;

    /**
     * Constructor
     */
    public RetoJava7Impl()
    {
        //If we want the result sorted we muse set true 
        //in the constructor of the user processor
        this.userProcessor = new UserProcessorImpl(false);
        this.mailProcessor = new MailProcessorImpl(false);
    }

    /**
     * {@inheritDoc}
     */
    public List<String> filtrarCorreos(String nombres, String correos)
    {
        List<String> result = new ArrayList<String>();

        Set<String> userNameSet = userProcessor.processElements(nombres);
        Set<String> userMailSet = mailProcessor.processElements(correos);
        //
        userNameSet.retainAll(userMailSet);

        //result = new ArrayList<String>(userMailSet);
        for (String username : userNameSet)
        {
            result.add(username + Constants.AT_SYMBOL + Constants.COMPANY_MAIL);
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Starting...");

        String homePath = System.getProperty(Constants.SYSTEM_USER_DIR) + Constants.SEPARATOR + Constants.TEST_DIR +
            Constants.SEPARATOR;

        RetoJava7 reto = new RetoJava7Impl();
        long time1 = System.nanoTime();
        List<String> list = reto.filtrarCorreos(homePath + Constants.FILE_USERS, homePath + Constants.FILE_MAILS);
        long time2 = System.nanoTime();
        System.out.println("Result: " + list);
        System.out.println("Time: " + ((time2 - time1) / 1000000) + " miliseconds.");

        System.out.println("End.");
    }
}
