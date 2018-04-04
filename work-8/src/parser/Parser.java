package parser;

import expressions.TripleExpression;
import parser.exceptions.ParseException;

public interface Parser<T> {
    TripleExpression<T> parse(String expression) throws ParseException;
}
