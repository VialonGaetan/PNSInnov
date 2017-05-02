package fr.unice.polytech;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class PNSInnov
{
    private final Map<Idea, List<Student>> projects;

    public PNSInnov()
    {
        projects = new HashMap<Idea, List<Student>>();
    }
}
