package fr.unice.polytech;

import fr.unice.polytech.transmission.requests.AddIdea;
import fr.unice.polytech.transmission.requests.Request;

import java.io.*;
import java.util.Arrays;

/**
 * @author Alexandre Clement
 *         Created the 02/05/2017.
 */
public class Main
{
    private Main()
    {

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Student author = new Student("Morris", "Jean.Morris@mail.fr");
        Idea idea = new Idea("Tu pousses le bouchon un peu trop loin.", Arrays.asList(Techno.JAVA, Techno.PYTHON), author);
        Request sent_request = new AddIdea(idea);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(sent_request);
        objectOutputStream.close();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object received_request = objectInputStream.readObject();

        assert sent_request.equals(received_request) : String.format("input isn't equals to output%nDiff :%n\tinput \t:\t%s%n%n\toutput \t:\t%s", sent_request, received_request);
    }
}
