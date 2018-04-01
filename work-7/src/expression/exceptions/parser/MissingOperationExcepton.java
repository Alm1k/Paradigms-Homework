package expression.exceptions.parser;

public class MissingOperationExcepton extends ParseException {
    public MissingOperationExcepton(String expression, int begin) {
        super("Missing operation before position " + begin + "\n");
    }
}
