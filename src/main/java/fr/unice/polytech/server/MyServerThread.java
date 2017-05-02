package fr.unice.polytech.server;

import fr.unice.polytech.Project;
import fr.unice.polytech.transmission.answers.JoinIdeaResult;
import fr.unice.polytech.transmission.answers.RespondingCode;
import fr.unice.polytech.transmission.requests.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Gaetan Vialon
 *         Created the 02/05/2017.
 */
public class MyServerThread extends Thread {

    private Socket socket;
    private Project project;

    public MyServerThread(Socket socket) {
        super("MyServerThread");
        this.socket = socket;
        project = new Project();
    }

    public void run() {

        //Création de la connexion côté serveur, en spécifiant un port d'écoute

        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            //PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            Request object = (Request) in.readObject();

            switch (object.getType()){
                case JOIN:
                    out.writeObject(new JoinIdeaResult(new RespondingCode(0)));
                    break;

                default:
                    out.writeObject(new JoinIdeaResult(new RespondingCode(1)));
                    break;
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
