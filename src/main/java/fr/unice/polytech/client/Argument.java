package fr.unice.polytech.client;

import java.util.regex.Pattern;

/**
 * @author Alexandre Clement
 *         Created the 07/05/2017.
 */
enum Argument
{
    ADD_IDEA(Type.MATCH_IDEA),
    JOIN_IDEA(Type.MATCH_IDEA_AND_STUDENT),
    LIST_PARTICIPANT(Type.MATCH_IDEA),
    LIST_IDEA(Type.EMPTY);

    private final String description;
    private final Pattern pattern;
    private final Type type;

    Argument(Type type)
    {
        this.type = type;
        description = String.format(type.getFormat(), name());
        pattern = Pattern.compile('^' + String.format(type.getPattern(), name()) + '$');
    }

    Type getType()
    {
        return type;
    }

    Pattern getPattern()
    {
        return pattern;
    }

    String getDescription()
    {
        return description;
    }
}