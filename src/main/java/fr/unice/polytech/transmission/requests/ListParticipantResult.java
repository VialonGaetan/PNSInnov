package fr.unice.polytech.transmission.requests;

import fr.unice.polytech.Idea;
import fr.unice.polytech.Student;
import fr.unice.polytech.transmission.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class ListParticipantResult implements Request
{
    private final Idea idea;

    public ListParticipantResult()
    {
        this(new Idea());
    }

    public ListParticipantResult(Idea idea)
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
