package fr.unice.polytech.rmi;

import fr.unice.polytech.transmission.answers.AddIdeaResult;
import fr.unice.polytech.transmission.answers.JoinIdeaResult;
import fr.unice.polytech.transmission.answers.ListIdeaResult;
import fr.unice.polytech.transmission.answers.ListParticipantResult;
import fr.unice.polytech.transmission.requests.AddIdea;
import fr.unice.polytech.transmission.requests.JoinIdea;
import fr.unice.polytech.transmission.requests.ListIdea;
import fr.unice.polytech.transmission.requests.ListParticipant;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Alexandre Clement
 *         Created the 23/05/2017.
 */
public interface Service extends Remote
{
    AddIdeaResult addIdea(AddIdea addIdea) throws RemoteException;

    JoinIdeaResult joinIdea(JoinIdea joinIdea) throws RemoteException;

    ListIdeaResult listIdea(ListIdea listIdea) throws RemoteException;

    ListParticipantResult listParticipant(ListParticipant listParticipant) throws RemoteException;
}
