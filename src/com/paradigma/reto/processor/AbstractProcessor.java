package com.paradigma.reto.processor;

import java.io.BufferedReader;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * Generic implementation of a file processor using a template pattern.
 * @author Álvaro Navarro
 */
public abstract class AbstractProcessor
{
    /**
     * Set to store all the processed elements
     */
    private Set<String> resultSet;

    /**
     * Constructor
     * @param sorted
     */
    public AbstractProcessor(boolean sorted)
    {
        if (sorted)
        {
            resultSet = new TreeSet<String>();
        }
        else
        {
            resultSet = new HashSet<String>();
        }
    }

    /**
     * @param pathFile
     * @return Set<String> a set with the processed elements.
     */
    public Set<String> processElements(String pathFile)
    {
        Path path = FileSystems.getDefault().getPath(pathFile);

        try
        {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);

            String line = null;

            while ((line = reader.readLine()) != null)
            {
                resultSet.add(processElement(line));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return resultSet;
    }

    /**
     * @param line
     * @return String with the processed element
     */
    protected abstract String processElement(String line);
}
