package fr.unice.polytech.transmission.answers;

import fr.unice.polytech.Idea;
import fr.unice.polytech.transmission.Type;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class ListIdeaResult implements Answer
{
    private final RespondingCode respondingCode;
    private final Set<Idea> ideas;

    public ListIdeaResult()
    {
        this(new RespondingCode(), new HashSet<Idea>());
    }

    /**
     * Reponse à la requete ListIdea
     * @param respondingCode 0 si tout va bien
     * @param ideas Ensemble de toutes les idées
     */
    public ListIdeaResult(RespondingCode respondingCode, Set<Idea> ideas)
    {
        this.respondingCode = respondingCode;
        this.ideas = ideas;
    }

    public Type getType()
    {
        return Type.IDEA_LIST;
    }

    @Override
    public RespondingCode getRespondingCode() {
        return respondingCode;
    }

    @Override
    public String toString()
    {
        return String.format("List Idea code : %d%n\t%s", respondingCode.getCode(), ideas);
    }
}
