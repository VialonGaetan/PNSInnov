package fr.unice.polytech.server.Builder;

import fr.unice.polytech.Project;
import fr.unice.polytech.transmission.answers.AddIdeaResult;
import fr.unice.polytech.transmission.answers.Answer;
import fr.unice.polytech.transmission.answers.RespondingCode;
import fr.unice.polytech.transmission.requests.AddIdea;
import fr.unice.polytech.transmission.requests.Request;

/**
 * @author Gaetan Vialon
 *         Created the 09/05/2017.
 */
public class AddIdeaResult_Builder implements AnswerBuilder {

    private RespondingCode respondingCode;

    @Override
    public AddIdeaResult build(Request request, Project project) {
        AddIdea idea = (AddIdea) request;
        if ((!project.getIdeaSet().isEmpty()) && project.getIdeaSet().contains(idea.getIdea()))
            respondingCode = new RespondingCode(1);
        else {
            project.addIdea(idea.getIdea());
            respondingCode = new RespondingCode(0);
        }

        return new AddIdeaResult(respondingCode);
    }
}
