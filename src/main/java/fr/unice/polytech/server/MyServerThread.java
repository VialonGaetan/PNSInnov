package fr.unice.polytech.server;

import fr.unice.polytech.Project;
import fr.unice.polytech.server.Builder.*;
import fr.unice.polytech.transmission.answers.*;
import fr.unice.polytech.transmission.requests.AddIdea;
import fr.unice.polytech.transmission.requests.JoinIdea;
import fr.unice.polytech.transmission.requests.ListParticipant;
import fr.unice.polytech.transmission.requests.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Gaetan Vialon
 *         Created the 02/05/2017.
 */
public class MyServerThread extends Thread {

    private Socket socket;
    private Project project;
    private static final Logger LOGGER = Logger.getLogger(MultiServer.class.getName());
    private static final AnswerBuilder[] builders = {new JoinIdeaResult_Builder(), new AddIdeaResult_Builder(), new ListParticipantResult_Builder(), new ListIdeaResult_Builder()};

    public MyServerThread(Socket socket, Project project) {
        super("MyServerThread");
        this.socket = socket;
        this.project = project;

    }

    public void run() {

        //Création de la connexion côté serveur, en spécifiant un port d'écoute

        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            Object object = in.readObject();
            LOGGER.log(Level.INFO, () -> String.format("new client by port : %s", socket.getPort()));

            if (object instanceof Request)
            {
                Request request = (Request) object;
                out.writeObject(builders[request.getType().ordinal()].build(request, project));
            }

            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
