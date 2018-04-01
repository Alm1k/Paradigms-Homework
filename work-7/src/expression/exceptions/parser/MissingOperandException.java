package expression.exceptions.parser;

public class MissingOperandException extends ParseException {
    public MissingOperandException(String expression, int begin) {
        super("Missing operand before position: " + begin + "\n" + expression);
    }
}
