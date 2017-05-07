package fr.unice.polytech.client;

import fr.unice.polytech.Techno;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Alexandre Clement
 *         Created the 07/05/2017.
 */
enum Type
{
    EMPTY("%s", "\\s*%s\\s*?"),
    MATCH_IDEA(EMPTY.format + " \"description of the idea\" technology... author mail@domain.net", EMPTY.pattern + " (?<idea>\"(?<description>.+?)\"\\s+(?<technos>(?:" + Arrays.stream(Techno.values()).map(Enum::toString).collect(Collectors.joining(" |")) + " )*)\\s*(?<author>(?<authorName>\\w+)\\s+(?<authorMail>[^\\s@]+@[^\\s@]+)\\s*?))"),
    MATCH_IDEA_AND_STUDENT(MATCH_IDEA.format + " new_member's_name new_member_mail@domain.net", MATCH_IDEA.pattern + " (?<student>(?<studentName>\\w+)\\s+(?<studentMail>.+?@.+?))\\s*");

    private final String format;
    private final String pattern;

    Type(String format, String pattern)
    {
        this.format = format;
        this.pattern = pattern;
    }

    String getFormat()
    {
        return format;
    }

    String getPattern()
    {
        return pattern;
    }
}
