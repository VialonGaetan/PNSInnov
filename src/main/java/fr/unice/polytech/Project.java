package fr.unice.polytech;

import java.util.*;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class Project
{
    private final Map<Idea, List<Student>> projects;

    /**
     * Ensemble contenant l'ensemble des idées et les membres pour chaque idée
     */
    public Project()
    {
        projects = new HashMap<Idea, List<Student>>();
    }

    /**
     * L'ensemble de toutes les idées soumises
     * @return Toutes les idées proposées
     */
    public Set<Idea> getIdeaSet()
    {
        return projects.keySet();
    }

    public void addIdea(Idea idea){
        projects.putIfAbsent(idea,new ArrayList<>());
        addStudentToAProject(idea, idea.getAuthor());
    }

    public void addStudentToAProject(Idea idea, Student student){
        projects.get(idea).add(student);
    }

    public List<Student> getStudentListOfAProject(Idea idea){
        return projects.get(idea);
    }
}
