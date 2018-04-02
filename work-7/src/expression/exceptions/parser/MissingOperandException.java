package expression.exceptions.parser;

public class MissingOperandException extends ParseException {
    public MissingOperandException(String expression, int index) {
        super("Missing operand", expression, index);
    }
}
