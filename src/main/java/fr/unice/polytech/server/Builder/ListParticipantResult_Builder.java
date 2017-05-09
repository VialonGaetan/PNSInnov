package fr.unice.polytech.server.Builder;

import fr.unice.polytech.Project;
import fr.unice.polytech.Student;
import fr.unice.polytech.transmission.answers.Answer;
import fr.unice.polytech.transmission.answers.ListParticipantResult;
import fr.unice.polytech.transmission.answers.RespondingCode;
import fr.unice.polytech.transmission.requests.ListParticipant;
import fr.unice.polytech.transmission.requests.Request;

import java.util.List;

/**
 * @author Gaetan Vialon
 *         Created the 09/05/2017.
 */
public class ListParticipantResult_Builder implements AnswerBuilder{

    private RespondingCode respondingCode;
    private List<Student> students;

    @Override
    public ListParticipantResult build(Request request, Project project) {
        ListParticipant list = (ListParticipant) request;

        if (project.getIdeaSet().isEmpty()){
            respondingCode = new RespondingCode(1);
            students = null;
        }
        if (!project.getIdeaSet().contains(list.getIdea())){
            respondingCode = new RespondingCode(2);
            students= null;
        }
        else {
            respondingCode = new RespondingCode(0);
            students = project.getStudentListOfAProject(list.getIdea());
        }
        return new ListParticipantResult(respondingCode,students);
    }
}
