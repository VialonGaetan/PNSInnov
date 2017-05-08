package fr.unice.polytech;

import java.io.Serializable;

/**
 * @author Alexandre Clement
 *         Created the 25/04/2017.
 */
public class Student implements Serializable
{
    private final String name;
    private final String mail;

    public Student()
    {
        this("", "");
    }

    /**
     * Un etudiant est defini par son nom et par son mail
     * @param name nom de l'etudiant
     * @param mail mail de l'etudiant
     */
    public Student(String name, String mail)
    {
        this.name = name;
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Student student = (Student) o;

        return name.equals(student.name) && mail.equals(student.mail);
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    @Override
    public String toString()
    {
        return String.format("Student[\"%s\", \"%s\"]", name, mail);
    }
}
