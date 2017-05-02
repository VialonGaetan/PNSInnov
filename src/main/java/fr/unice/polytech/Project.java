package fr.unice.polytech;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class Project
{
    private final Map<Idea, List<Student>> projects;

    public Project()
    {
        projects = new HashMap<Idea, List<Student>>();
    }

    public Set<Idea> getIdeaSet()
    {
        return projects.keySet();
    }
}
