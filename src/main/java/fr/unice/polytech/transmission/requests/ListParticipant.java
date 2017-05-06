package fr.unice.polytech.transmission.requests;

import fr.unice.polytech.Idea;
import fr.unice.polytech.transmission.Type;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class ListParticipant implements Request
{
    private final Idea idea;

    public ListParticipant()
    {
        this(new Idea());
    }

    public ListParticipant(Idea idea)
    {
        this.idea = idea;
    }

    public Type getType()
    {
        return Type.PARTICIPANT_LIST;
    }

    public Idea getIdea()
    {
        return idea;
    }
}
