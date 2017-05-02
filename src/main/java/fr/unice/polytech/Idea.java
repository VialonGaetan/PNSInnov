package fr.unice.polytech;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Clement
 *         Created the 25/04/2017.
 */
public class Idea implements Serializable
{
    private final String description;
    private final List<Techno> technos;
    private final Student author;

    public Idea()
    {
        this("", new ArrayList<Techno>(), new Student());
    }

    public Idea(String description, List<Techno> technos, Student author)
    {
        this.description = description;
        this.technos = technos;
        this.author = author;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Idea idea = (Idea) o;

        return description.equals(idea.description) && technos.equals(idea.technos) && author.equals(idea.author);
    }

    @Override
    public int hashCode()
    {
        int result = description.hashCode();
        result = 31 * result + technos.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return String.format("Idea[description=\"%s\", technos=%s, author=%s]", description, technos, author);
    }
}
