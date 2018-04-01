package expression.exceptions.parser;

public class IllegalIdentifierException extends ParseException {
    public IllegalIdentifierException(int begin) {
        super("Identifier need starts with letter\n" + "Exception at: " + begin);
    }

    public IllegalIdentifierException(String content) {
        super("Wrong identifier name: " + content);
    }
}
