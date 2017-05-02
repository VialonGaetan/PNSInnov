package fr.unice.polytech.transmission.requests;

import fr.unice.polytech.Idea;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class CreateIdea implements Request
{
    private final Idea idea;

    public CreateIdea(Idea idea)
    {
        this.idea = idea;
    }

    public Type getType()
    {
        return Type.CREATE;
    }

    public Idea getIdea()
    {
        return idea;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CreateIdea that = (CreateIdea) o;

        return idea.equals(that.idea);
    }

    @Override
    public int hashCode()
    {
        return idea.hashCode();
    }

    @Override
    public String toString()
    {
        return String.format("CreateIdea(%s)", idea);
    }
}
