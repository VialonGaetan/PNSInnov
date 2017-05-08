package fr.unice.polytech.transmission.answers;

import fr.unice.polytech.transmission.Transmission;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public interface Answer extends Transmission
{
    RespondingCode getRespondingCode();
}
