package fr.unice.polytech.transmission.requests;

import java.io.Serializable;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public interface Request extends Serializable
{
    Type getType();
}
