package fr.unice.polytech.client.builder.request;

import fr.unice.polytech.Idea;
import fr.unice.polytech.Student;
import fr.unice.polytech.Techno;
import fr.unice.polytech.transmission.requests.JoinIdea;

import java.util.regex.Matcher;

/**
 * @author Alexandre Clement
 *         Created the 07/05/2017.
 */
public class JoinIdeaBuilder implements RequestBuilder<JoinIdea>
{
    @Override
    public JoinIdea build(Matcher matcher)
    {
        Student student = new Student(matcher.group(NamedGroup.authorName.toString()), matcher.group(NamedGroup.authorMail.toString()));
        Idea idea = new Idea(matcher.group(NamedGroup.description.toString()), Techno.valuesOf(matcher.group(NamedGroup.technos.toString())), student);
        Student member = new Student(matcher.group(NamedGroup.studentName.toString()), matcher.group(NamedGroup.studentMail.toString()));
        return new JoinIdea(member, idea);
    }
}
