package expression.exceptions.parser;

public class OddClosingException extends ParseException {
    public OddClosingException(String expression, int begin) {
        super("Wrong number of closing: " + expression + " at " + begin);
    }
}
