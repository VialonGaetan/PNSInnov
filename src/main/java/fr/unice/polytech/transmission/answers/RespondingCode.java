package fr.unice.polytech.transmission.answers;

import java.io.Serializable;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class RespondingCode implements Serializable
{
    private int code;

    public RespondingCode()
    {
        this(0);
    }

    /**
     * Code permettant de definir si une requete s'est bien passée
     * @param code code de retour
     */
    public RespondingCode(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }
}
