package expression.exceptions.parser;

public class ParseException extends Exception {
    ParseException(String message, String string, int position) {
        super(String.format("%s in \"%s\" at index %d", message, string, position));
    }

    public ParseException(String message, String expression) {
        super(String.format("%s for \"%s\")", message, expression));
    }
}
