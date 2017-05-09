package fr.unice.polytech.server.Builder;

import fr.unice.polytech.Project;
import fr.unice.polytech.transmission.answers.Answer;
import fr.unice.polytech.transmission.answers.JoinIdeaResult;
import fr.unice.polytech.transmission.answers.RespondingCode;
import fr.unice.polytech.transmission.requests.JoinIdea;
import fr.unice.polytech.transmission.requests.Request;

/**
 * @author Gaetan Vialon
 *         Created the 09/05/2017.
 */
public class JoinIdeaResult_Builder implements AnswerBuilder {

    private RespondingCode respondingCode;

    @Override
    public JoinIdeaResult build(Request request, Project project) {
        JoinIdea joinIdea = (JoinIdea) request;

        if (project.getIdeaSet().isEmpty()){
            respondingCode=new RespondingCode(1);
        }
        else if(!project.getIdeaSet().contains(joinIdea.getIdea())){
            respondingCode=new RespondingCode(2);
        }
        else if (project.getStudentListOfAProject(joinIdea.getIdea()).contains(joinIdea.getStudent())){
            respondingCode=new RespondingCode(3);
        }
        else{
            project.addStudentToAProject(joinIdea.getIdea(),joinIdea.getStudent());
            respondingCode=new RespondingCode(0);
        }

        return new JoinIdeaResult(respondingCode);
    }
}
