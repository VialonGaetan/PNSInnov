package fr.unice.polytech.client.builder.request;

import fr.unice.polytech.transmission.requests.ListIdea;

import java.util.regex.Matcher;

/**
 * @author Alexandre Clement
 *         Created the 07/05/2017.
 */
public class ListIdeaBuilder implements RequestBuilder<ListIdea>
{
    @Override
    public ListIdea build(Matcher matcher)
    {
        return new ListIdea();
    }
}
