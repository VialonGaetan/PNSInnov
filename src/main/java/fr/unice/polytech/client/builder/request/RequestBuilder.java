package fr.unice.polytech.client.builder.request;

import fr.unice.polytech.transmission.requests.Request;

import java.util.regex.Matcher;

/**
 * @author Alexandre Clement
 *         Created the 07/05/2017.
 */
@FunctionalInterface
public interface RequestBuilder<T extends Request>
{
    T build(Matcher matcher);
}
