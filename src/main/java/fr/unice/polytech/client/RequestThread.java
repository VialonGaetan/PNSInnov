package fr.unice.polytech.client;

import fr.unice.polytech.transmission.answers.Answer;
import fr.unice.polytech.transmission.requests.Request;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alexandre Clement
 *         Created the 07/05/2017.
 */
class RequestThread implements Runnable
{
    private static final Logger LOGGER = Logger.getLogger(Client.class.getName());
    private final Request request;
    private final Socket socket;
    private final ObjectInputStream in;
    private final ObjectOutputStream out;

    RequestThread(Request request, Socket socket) throws IOException
    {
        this.request = request;
        this.socket = socket;
        out = new ObjectOutputStream(new PrintStream(socket.getOutputStream()));
        in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
    }

    public void run()
    {
        try
        {
            LOGGER.log(Level.INFO, () -> String.format("sent request : %s", request.toString()));
            out.writeObject(request);
            Object object = in.readObject();
            Answer answer = (Answer) object;
            LOGGER.log(Level.INFO, () -> String.format("received object : %s", object.toString()));
            System.out.println(answer.getRespondingCode().getCode());
            in.close();
            out.close();
            socket.close();
        }
        catch (IOException | ClassNotFoundException exception)
        {
            LOGGER.log(Level.WARNING, String.format("Error while sending request : %s", request), exception);
        }
    }
}