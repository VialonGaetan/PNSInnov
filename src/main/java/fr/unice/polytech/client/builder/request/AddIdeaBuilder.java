package fr.unice.polytech.client.builder.request;

import fr.unice.polytech.Idea;
import fr.unice.polytech.Student;
import fr.unice.polytech.Techno;
import fr.unice.polytech.transmission.requests.AddIdea;

import java.util.regex.Matcher;

/**
 * @author Alexandre Clement
 *         Created the 07/05/2017.
 */
public class AddIdeaBuilder implements RequestBuilder<AddIdea>
{
    @Override
    public AddIdea build(Matcher matcher)
    {
        Student student = new Student(matcher.group(NamedGroup.authorName.toString()), matcher.group(NamedGroup.authorMail.toString()));
        Idea idea = new Idea(matcher.group(NamedGroup.description.toString()), Techno.valuesOf(matcher.group(NamedGroup.technos.toString())), student);
        return new AddIdea(idea);
    }
}
