package fr.unice.polytech.rmi.Builder;

import fr.unice.polytech.rmi.Service;
import fr.unice.polytech.transmission.answers.AddIdeaResult;
import fr.unice.polytech.transmission.requests.AddIdea;
import fr.unice.polytech.transmission.requests.Request;

import java.rmi.RemoteException;

/**
 * @author Gaetan Vialon
 *         Created the 09/05/2017.
 */
public class AddIdeaResult_Builder implements AnswerBuilder
{
    @Override
    public AddIdeaResult build(Request request, Service service) throws RemoteException
    {
        return service.addIdea((AddIdea) request);
    }
}
