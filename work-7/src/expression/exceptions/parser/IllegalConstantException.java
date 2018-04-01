package expression.exceptions.parser;

public class IllegalConstantException extends ParseException {
    public IllegalConstantException(String content) {
        super("Can't create const: " + content);
    }
}
