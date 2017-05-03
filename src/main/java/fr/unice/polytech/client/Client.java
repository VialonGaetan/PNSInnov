package fr.unice.polytech.client;

import fr.unice.polytech.Idea;
import fr.unice.polytech.Student;
import fr.unice.polytech.Techno;
import fr.unice.polytech.transmission.answers.AddIdeaResult;
import fr.unice.polytech.transmission.answers.Answer;
import fr.unice.polytech.transmission.answers.JoinIdeaResult;
import fr.unice.polytech.transmission.requests.AddIdea;
import fr.unice.polytech.transmission.requests.JoinIdea;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class Client implements Runnable
{
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Client(String host, int port) throws IOException
    {
        socket = new Socket(host, port);
        out = new ObjectOutputStream(new PrintStream(socket.getOutputStream()));
        in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
    }

    public void run()
    {
        try
        {
            Student bob = new Student("Bob", "Bob@eponge.sea");
            Student patrick = new Student("Patrick", "patrick@star.sea");
            Idea idea = new Idea("Ah que coucou Patrick", Arrays.asList(Techno.JAVA, Techno.PYTHON), bob);

            // out.writeObject(new JoinIdea(patrick, idea));
            out.writeObject(new AddIdea(idea));

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
        Client client = new Client(null, 15555);
        new Thread(client).start();
    }

    private enum Argument
    {
        ADD, JOIN, PART, IDEA
    }
}
