package fr.unice.polytech.transmission.requests;

import fr.unice.polytech.Idea;
import fr.unice.polytech.transmission.Type;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class ListIdea implements Request
{
    public Type getType()
    {
        return Type.IDEA_LIST;
    }
}
