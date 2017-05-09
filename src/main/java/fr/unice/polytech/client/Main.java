package fr.unice.polytech.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Alexandre Clement
 *         Created the 07/05/2017.
 */
public class Main
{
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final String HELP = String.format("Available command : %n\t%s", Arrays.stream(Argument.values()).map(Argument::getDescription).collect(Collectors.joining("\n\t")));

    private Main()
    {
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println(HELP);
        Scanner scanner = new Scanner(System.in);
        Client client = new Client("10.212.127.229", 15555);

        try
        {
            while (scanner.hasNextLine())
            {
                new Thread(client.sendRequest(scanner.nextLine())).start();
            }
        }
        catch (InvalidRequest invalidRequest)
        {
            LOGGER.log(Level.WARNING, "Client will stop", invalidRequest);
        }
    }
}
