package expression.exceptions.parser;

public class NoOpeningParenthesisException extends ParseException {
    public NoOpeningParenthesisException(String expression, int index) {
        super("No opening parenthesis", expression, index);
    }
}
