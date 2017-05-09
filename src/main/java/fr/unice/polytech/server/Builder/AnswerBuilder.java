package fr.unice.polytech.server.Builder;

import fr.unice.polytech.Project;
import fr.unice.polytech.transmission.answers.Answer;
import fr.unice.polytech.transmission.requests.Request;

import java.util.regex.Matcher;

/**
 * @author Gaetan Vialon
 *         Created the 09/05/2017.
 */
public interface AnswerBuilder<T extends Answer>{

    T build(Request request, Project project);
}

