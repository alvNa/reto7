package com.paradigma.reto.util;

import com.paradigma.reto.constant.Constants;

import java.text.Normalizer;

import java.util.StringTokenizer;
import java.util.regex.Pattern;


/**
 * Utilities to be used in the application.
 *
 * @author Ã�lvaro Navarro
 */
public final class Utils
{
    /**
     * Given a mail of a person returns itÂ´s username.
     * Ej: jrola@empresa.com returns jrola
     * @param mail
     * @return String the username of the mail
     */
    public static String processMail(String mail)
    {
        StringTokenizer userName = new StringTokenizer(mail, Constants.AT_SYMBOL);

        return userName.nextToken();
    }

    /**
     * Given a name of a person in the format specified returns the username
     * of yhis person.
     * Ej: JosÃ© Luis, RamÃ³n returns jlramon
     * @param name
     * @return String the username of one person
     */
    public static String processName(String name)
    {
        StringTokenizer userName = new StringTokenizer(name);
        boolean surName = false;
        StringBuilder result = new StringBuilder();
        String token = "";

        while (userName.hasMoreTokens())
        {
            token = userName.nextToken();

            if (!surName)
            {
                result.append(token.trim().substring(0, 1).toLowerCase());
                surName = token.contains(Constants.COMMA);
            }
            else
            {
            	result.append(unAccent(token.trim().toLowerCase()));
            }
        }

        return result.toString();
    }

    /**
     * Replace the accented letters and the special characters.
     * @param s
     * @return String
     */
    public static String unAccent(String s)
    {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

        return pattern.matcher(temp).replaceAll("");
    }
}
