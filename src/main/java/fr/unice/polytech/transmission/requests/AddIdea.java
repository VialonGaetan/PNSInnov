package fr.unice.polytech.transmission.requests;

import fr.unice.polytech.Idea;
import fr.unice.polytech.transmission.Type;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class AddIdea implements Request
{
    private final Idea idea;

    public AddIdea()
    {
        this(new Idea());
    }

    /**
     * Requete permettant d'ajouter d'une idée
     * @param idea : idée que l'on veut ajouter
     */
    public AddIdea(Idea idea)
    {
        this.idea = idea;
    }

    public Type getType()
    {
        return Type.ADD;
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

        AddIdea that = (AddIdea) o;

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
        return String.format("AddIdea(%s)", idea);
    }
}
