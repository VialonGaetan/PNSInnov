package fr.unice.polytech.transmission.answers;

import fr.unice.polytech.Student;
import fr.unice.polytech.transmission.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class ListParticipantResult implements Answer
{
    private final RespondingCode respondingCode;
    private final List<Student> participants;

    public ListParticipantResult()
    {
        this(new RespondingCode(), new ArrayList<Student>());
    }

    /**
     * Reponse à la requete ListParticipant
     * @param respondingCode 0 si tout va bien
     * @param participants Liste des participants
     */
    public ListParticipantResult(RespondingCode respondingCode, List<Student> participants)
    {
        this.respondingCode = respondingCode;
        this.participants = participants;
    }

    public Type getType()
    {
        return Type.PARTICIPANT_LIST;
    }

    public List<Student> getParticipants()
    {
        return participants;
    }

    @Override
    public RespondingCode getRespondingCode() {
        return respondingCode;
    }

    @Override
    public String toString()
    {
        return String.format("List Participant code : %d%n\t%s", respondingCode.getCode(), participants);
    }
}
