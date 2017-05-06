package fr.unice.polytech.client;

import fr.unice.polytech.Idea;
import fr.unice.polytech.Student;
import fr.unice.polytech.Techno;
import fr.unice.polytech.transmission.answers.JoinIdeaResult;
import fr.unice.polytech.transmission.requests.*;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class Client implements Runnable
{
    private static final String HELP = String.format("Available command : %s",
            Arrays.stream(Argument.values()).map(Enum::toString).collect(Collectors.joining("\", \"", "\"", "\"")));
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private final Argument argument;

    Client(String host, int port, Argument argument) throws IOException
    {
        this.argument = argument;
        socket = new Socket(host, port);
        out = new ObjectOutputStream(new PrintStream(socket.getOutputStream()));
        in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
    }

    public void run()
    {
        Student bob = new Student("Bob", "Bob@eponge.sea");
        Student patrick = new Student("Patrick", "patrick@star.sea");
        Idea idea = new Idea("Ah que coucou Patrick", Arrays.asList(Techno.JAVA, Techno.PYTHON), bob);

        Request[] requests = {new AddIdea(idea), new JoinIdea(patrick, idea), new ListParticipant(idea), new ListIdea()};

        try
        {
            out.writeObject(requests[argument.ordinal()]);

            System.out.println(((JoinIdeaResult) in.readObject()).getRespondingCode().getCode());

            socket.close();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println(HELP);
        Scanner scanner = new Scanner(System.in);
        Argument argument;
        while (scanner.hasNextLine())
        {
            try
            {
                argument = Argument.valueOf(scanner.nextLine());
            }
            catch (IllegalArgumentException exception)
            {
                break;
            }
            Client client = new Client(null, 15555, argument);
            new Thread(client).start();
        }
    }

    private enum Argument
    {
        ADD, JOIN, PART, IDEA
    }
}
