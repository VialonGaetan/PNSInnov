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

        return name.equals(student.name);
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    @Override
    public String toString()
    {
        return String.format("Student[\"%s\"]", name);
    }
}
