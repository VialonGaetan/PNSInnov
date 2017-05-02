package fr.unice.polytech.transmission.answers;

import fr.unice.polytech.transmission.Type;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class AddIdeaResult implements Answer
{
    private final RespondingCode respondingCode;

    public AddIdeaResult()
    {
        this(new RespondingCode());
    }

    public AddIdeaResult(RespondingCode respondingCode)
    {
        this.respondingCode = respondingCode;
    }

    public Type getType()
    {
        return Type.ADD;
    }
}
