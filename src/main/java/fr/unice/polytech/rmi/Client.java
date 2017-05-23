package fr.unice.polytech.rmi;

import fr.unice.polytech.client.Argument;
import fr.unice.polytech.client.InvalidRequest;
import fr.unice.polytech.client.Main;
import fr.unice.polytech.client.builder.request.*;
import fr.unice.polytech.rmi.Builder.*;
import fr.unice.polytech.transmission.answers.Answer;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
class Client
{
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final String HELP = String.format("Available command : %n\t%s", Arrays.stream(Argument.values()).map(Argument::getDescription).collect(Collectors.joining("\n\t")));
    private static final AnswerBuilder[] answerBuilders = {new JoinIdeaResult_Builder(), new AddIdeaResult_Builder(), new ListParticipantResult_Builder(), new ListIdeaResult_Builder()};
    private static final RequestBuilder[] builders = {new AddIdeaBuilder(), new JoinIdeaBuilder(), new ListParticipantBuilder(), new ListIdeaBuilder()};
    private final String host;
    private final int port;

    Client(String host, int port) throws IOException
    {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) throws Exception
    {
        if (args.length != 1)
            throw new IllegalArgumentException();

        Registry registry = LocateRegistry.getRegistry(args[0], 15555);
        Service stub = (Service) registry.lookup("PNSInnov");

        System.out.println(HELP);
        Scanner scanner = new Scanner(System.in);
        Client client = new Client(args[0], 15555);

        try
        {
            while (scanner.hasNextLine())
            {
                System.out.println(client.sendRequest(stub, scanner.nextLine()));
            }
        }
        catch (InvalidRequest invalidRequest)
        {
            LOGGER.log(Level.WARNING, "Client will stop", invalidRequest);
        }
    }

    Answer sendRequest(Service stub, String request) throws InvalidRequest, IOException
    {
        for (Argument arg : Argument.values())
        {
            Matcher matcher = arg.getPattern().matcher(request);
            if (matcher.matches())
                return answerBuilders[arg.ordinal()].build(builders[arg.ordinal()].build(matcher), stub);
        }
        throw new InvalidRequest();
    }
}
