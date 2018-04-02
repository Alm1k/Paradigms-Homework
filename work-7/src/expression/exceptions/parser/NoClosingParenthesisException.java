package expression.exceptions.parser;

class NoClosingParenthesisException extends ParseException {
    NoClosingParenthesisException(String expression, int index) {
        super("Missing closing", expression, index);
    }
}
