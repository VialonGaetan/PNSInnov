package fr.unice.polytech;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Clement
 *         Created the 25/04/2017.
 */
public enum Techno
{
    JAVA, PYTHON;

    public static List<Techno> valuesOf(String string)
    {
        List<Techno> technos = new ArrayList<>();

        if (string.isEmpty())
            return technos;

        String[] args = string.split("\\s+");
        for (String techno : args)
        {
            technos.add(Techno.valueOf(techno));
        }
        return technos;
    }
}
