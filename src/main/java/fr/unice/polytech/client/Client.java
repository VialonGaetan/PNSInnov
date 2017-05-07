package fr.unice.polytech.client;

import fr.unice.polytech.client.builder.request.*;

import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
class Client
{
    private static final RequestBuilder[] builders = {new AddIdeaBuilder(), new JoinIdeaBuilder(), new ListParticipantBuilder(), new ListIdeaBuilder()};
    private final String host;
    private final int port;

    Client(String host, int port) throws IOException
    {
        this.host = host;
        this.port = port;
    }

    Runnable sendRequest(String request) throws InvalidRequest, IOException
    {
        for (Argument arg : Argument.values())
        {
            Matcher matcher = arg.getPattern().matcher(request);
            if (matcher.matches())
                return new RequestThread(builders[arg.ordinal()].build(matcher), new Socket(host, port));
        }
        throw new InvalidRequest();
    }
}
