package expression.exceptions.parser;

import expression.exceptions.TripleExpression;

public interface Parser {
    TripleExpression parse(String expression) throws ParseException;
}
