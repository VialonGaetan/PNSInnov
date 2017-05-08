package fr.unice.polytech.transmission.requests;

import fr.unice.polytech.transmission.Type;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class ListIdea implements Request
{
    /**
     * Requete pour avoir la liste des idées
     */
    public ListIdea() {
    }

    public Type getType()
    {
        return Type.IDEA_LIST;
    }
}
