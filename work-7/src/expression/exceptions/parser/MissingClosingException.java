package expression.exceptions.parser;

public class MissingClosingException extends ParseException {
    public MissingClosingException(String expression, int position) {
        super("Mising closing symbol at position: " + position + "\n" + expression);
    }
}
