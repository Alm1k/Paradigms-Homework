package expression.exceptions.parser;

public class MissingOperationException extends ParseException {
    public MissingOperationException(String expression, int index) {
        super("Missing operation", expression, index);
    }
}
