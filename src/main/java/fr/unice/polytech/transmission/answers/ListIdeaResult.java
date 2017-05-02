package fr.unice.polytech.transmission.answers;

import fr.unice.polytech.Idea;
import fr.unice.polytech.transmission.Type;

import java.util.ArrayList;
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

    public ListIdeaResult(RespondingCode respondingCode, Set<Idea> ideas)
    {
        this.respondingCode = respondingCode;
        this.ideas = ideas;
    }

    public Type getType()
    {
        return Type.IDEA_LIST;
    }
}
