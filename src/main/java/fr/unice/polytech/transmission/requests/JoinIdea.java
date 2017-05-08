package fr.unice.polytech.transmission.requests;

import fr.unice.polytech.Idea;
import fr.unice.polytech.Student;
import fr.unice.polytech.transmission.Type;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class JoinIdea implements Request
{
    private final Student student;
    private final Idea idea;

    public JoinIdea()
    {
        this(new Student(), new Idea());
    }


    /**
     * Requete afin de rejoindre une idée
     * @param student etudiant qui veut rejoindre une idée
     * @param idea idée que celui-ci veut rejoindre
     */
    public JoinIdea(Student student, Idea idea)
    {
        this.student = student;
        this.idea = idea;
    }

    public Type getType()
    {
        return Type.JOIN;
    }

    public Idea getIdea()
    {
        return idea;
    }

    public Student getStudent()
    {
        return student;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        JoinIdea joinIdea = (JoinIdea) o;

        return student.equals(joinIdea.student) && idea.equals(joinIdea.idea);
    }

    @Override
    public int hashCode()
    {
        int result = student.hashCode();
        result = 31 * result + idea.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return String.format("JoinIdea(%s joinded %s)", student, idea);
    }
}
