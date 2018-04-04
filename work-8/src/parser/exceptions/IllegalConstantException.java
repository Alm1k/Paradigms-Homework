package parser.exceptions;

public class IllegalConstantException extends ParseException {
    public IllegalConstantException(String content, String expression, int index) {
        super("Can't create const with name " + content, expression, index);
    }
}
