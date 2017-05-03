package fr.unice.polytech.transmission.answers;

import fr.unice.polytech.transmission.Type;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class JoinIdeaResult implements Answer
{
    private final RespondingCode respondingCode;

    public JoinIdeaResult()
    {
        this(new RespondingCode());
    }

    public JoinIdeaResult(RespondingCode respondingCode)
    {
        this.respondingCode = respondingCode;
    }

    public Type getType()
    {
        return Type.JOIN;
    }

    public RespondingCode getRespondingCode()
    {
        return respondingCode;
    }
}
