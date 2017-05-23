package fr.unice.polytech.rmi;

import fr.unice.polytech.Project;
import fr.unice.polytech.transmission.answers.*;
import fr.unice.polytech.transmission.requests.AddIdea;
import fr.unice.polytech.transmission.requests.JoinIdea;
import fr.unice.polytech.transmission.requests.ListIdea;
import fr.unice.polytech.transmission.requests.ListParticipant;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;

/**
 * @author Alexandre Clement
 *         Created the 23/05/2017.
 */
public class Server implements Service
{
    private final Project project;

    public Server()
    {
        project = new Project();
    }

    public static void main(String args[])
    {
        try
        {
            Server server = new Server();
            Service stub = (Service) UnicastRemoteObject.exportObject(server, 15555);

            // Bind the remote object's stub in the registry
            LocateRegistry.createRegistry(15555);
            Registry registry = LocateRegistry.getRegistry(15555);
            registry.bind("PNSInnov", stub);

            System.out.println("Server ready");
        }
        catch (Exception e)
        {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public AddIdeaResult addIdea(AddIdea addIdea) throws RemoteException
    {
        project.addIdea(addIdea.getIdea());
        return new AddIdeaResult(new RespondingCode(0));
    }

    @Override
    public JoinIdeaResult joinIdea(JoinIdea joinIdea) throws RemoteException
    {
        project.addStudentToAProject(joinIdea.getIdea(), joinIdea.getStudent());
        return new JoinIdeaResult(new RespondingCode(0));
    }

    @Override
    public ListIdeaResult listIdea(ListIdea listIdea) throws RemoteException
    {
        return new ListIdeaResult(new RespondingCode(0), new HashSet<>(project.getIdeaSet()));
    }

    @Override
    public ListParticipantResult listParticipant(ListParticipant listParticipant) throws RemoteException
    {
        return new ListParticipantResult(new RespondingCode(0), project.getStudentListOfAProject(listParticipant.getIdea()));
    }
}
