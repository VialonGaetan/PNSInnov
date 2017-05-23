package fr.unice.polytech.rmi.Builder;

import fr.unice.polytech.rmi.Service;
import fr.unice.polytech.transmission.answers.Answer;
import fr.unice.polytech.transmission.requests.JoinIdea;
import fr.unice.polytech.transmission.requests.Request;

import java.rmi.RemoteException;

/**
 * @author Gaetan Vialon
 *         Created the 09/05/2017.
 */
public class JoinIdeaResult_Builder implements AnswerBuilder
{
    @Override
    public Answer build(Request request, Service service) throws RemoteException
    {
        return service.joinIdea((JoinIdea) request);
    }
}
