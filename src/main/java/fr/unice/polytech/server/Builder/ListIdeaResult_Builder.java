package fr.unice.polytech.server.Builder;

import fr.unice.polytech.Project;
import fr.unice.polytech.transmission.answers.Answer;
import fr.unice.polytech.transmission.answers.ListIdeaResult;
import fr.unice.polytech.transmission.answers.RespondingCode;
import fr.unice.polytech.transmission.requests.Request;

import java.util.HashSet;

/**
 * @author Gaetan Vialon
 *         Created the 09/05/2017.
 */
public class ListIdeaResult_Builder implements AnswerBuilder {


    @Override
    public ListIdeaResult build(Request request, Project project) {
        return new ListIdeaResult(new RespondingCode(0),new HashSet<>(project.getIdeaSet()));
    }
}
