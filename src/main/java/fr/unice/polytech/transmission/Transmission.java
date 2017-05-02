package fr.unice.polytech.transmission;

import java.io.Serializable;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public interface Transmission extends Serializable
{
    Type getType();
}
