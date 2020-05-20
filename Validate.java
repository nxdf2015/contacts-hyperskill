package contacts;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern phonePattern = Pattern.compile("^\\+?[\\s-]?" +
            "(" +
            "\\([a-z0-9]+\\)?|" +
            "\\([a-z0-9]+\\)[\\s-][a-z0-9]{2,}|" +
            "[a-z0-9]+|" +
            "[a-z0-9]+[\\s-][a-z0-9]{2,}|" +
            "[a-z0-9]+[\\s-]\\([a-z0-9]{2,}\\)|" +
            "\\([a-z0-9]{2,}\\)" +
            ")" +
            "(([\\s-][a-z0-9]{2,})*([\\s-][a-z0-9]{2,}))?",Pattern.CASE_INSENSITIVE);

    public static Optional<String> phone(String value) {
        Matcher matcher =phonePattern.matcher(value);
        if (matcher.matches())
            return Optional.of(value);
        else
            return Optional.empty();

    }
}
