package fr.unice.polytech.server;

import fr.unice.polytech.Project;
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

            Request object = (Request) in.readObject();
            LOGGER.log(Level.INFO, () -> String.format("new client by port : %s", socket.getPort()));
            LOGGER.log(Level.INFO, () -> String.format("Type Request : %s", object.getType()));

            switch (object.getType()){
                case JOIN:
                    JoinIdea joinIdea = (JoinIdea) object;
                    if (project.getIdeaSet().isEmpty()){
                        out.writeObject(new JoinIdeaResult(new RespondingCode(1)));//Il existe aucune idée
                    }
                    else if(!project.getIdeaSet().contains(joinIdea.getIdea())){
                        out.writeObject(new JoinIdeaResult(new RespondingCode(2)));//L'idée n'existe pas
                    }
                    else if (project.getStudentListOfAProject(joinIdea.getIdea()).contains(joinIdea.getStudent())){
                        out.writeObject(new JoinIdeaResult(new RespondingCode(3)));// L'étudiant a deja rejoint le projet
                    }
                    else{
                        project.addStudentToAProject(joinIdea.getIdea(),joinIdea.getStudent());
                        out.writeObject(new JoinIdeaResult(new RespondingCode(0)));
                    }
                    break;

                case ADD:
                    AddIdea idea = (AddIdea) object;
                    if ((!project.getIdeaSet().isEmpty()) && project.getIdeaSet().contains(idea.getIdea()))
                        out.writeObject(new AddIdeaResult(new RespondingCode(1)));//Projet existe déjà
                    else {
                        project.addIdea(idea.getIdea());
                        out.writeObject(new AddIdeaResult(new RespondingCode(0)));
                    }
                    break;

                case IDEA_LIST:
                    out.writeObject(new ListIdeaResult(new RespondingCode(0),new HashSet<>(project.getIdeaSet())));
                    break;

                case PARTICIPANT_LIST:
                    ListParticipant list = (ListParticipant) object;
                    if (project.getIdeaSet().isEmpty()){
                        out.writeObject(new ListParticipantResult(new RespondingCode(1),null));//Aucune idée
                    }
                    if (!project.getIdeaSet().contains(list.getIdea()))
                        out.writeObject(new ListParticipantResult(new RespondingCode(2),null));//idées n'existe pas
                    else
                        out.writeObject(new ListParticipantResult(new RespondingCode(0),project.getStudentListOfAProject(list.getIdea())));
                    break;

                default:
                    out.writeObject(new JoinIdeaResult(new RespondingCode(5)));
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
