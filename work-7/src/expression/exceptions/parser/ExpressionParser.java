package expression.exceptions.parser;

import expression.exceptions.TripleExpression;
import expression.exceptions.operands.binary.CheckedAdd;
import expression.exceptions.operands.binary.CheckedDivide;
import expression.exceptions.operands.binary.CheckedMultiply;
import expression.exceptions.operands.binary.CheckedSubtract;
import expression.exceptions.operands.unary.*;
import expression.exceptions.parser.tokenizer.Token;
import expression.exceptions.parser.tokenizer.Tokenizer;

public class ExpressionParser implements Parser {
    private Tokenizer tokenizer;

    @Override
    public TripleExpression parse(String expression) throws ParseException {
        tokenizer = new Tokenizer(expression);
        return parseAddSub();
    }

    private TripleExpression parseAddSub() throws ParseException {
        TripleExpression result = parseMulDiv();
        while (true) {
            switch (tokenizer.getToken()) {
                case ADD:
                    result = new CheckedAdd(result, parseMulDiv());
                    break;
                case SUB:
                    result = new CheckedSubtract(result, parseMulDiv());
                    break;
                default:
                    return result;
            }
        }
    }

    private TripleExpression parseMulDiv() throws ParseException {
        TripleExpression result = parseLower();
        while (true) {
            switch (tokenizer.getToken()) {
                case MUL:
                    result = new CheckedMultiply(result, parseLower());
                    break;
                case DIV:
                    result = new CheckedDivide(result, parseLower());
                    break;
                default:
                    return result;
            }
        }
    }

    private TripleExpression parseLower() throws ParseException {
        TripleExpression result;
        switch (tokenizer.getNextToken()) {
            case VARIABLE:
                result = new Variable(tokenizer.getContent());
                tokenizer.getNextToken();
                break;
            case CONST:
                result = new Const(tokenizer.getNumber());
                tokenizer.getNextToken();
                break;
            case INVERSE:
                result = new CheckedNegate(parseLower());
                break;
            case LOG:
                result = new CheckedLog10(parseLower());
                break;
            case POW:
                result = new CheckedPow10(parseLower());
                break;
            case BRACE_OPN:
                result = parseAddSub();
                if (tokenizer.getToken() != Token.BRACE_CLS) {
                    throw new NoClosingParenthesisException(tokenizer.getExpression(), tokenizer.getPosition());
                }
                tokenizer.getNextToken();
                break;
            default:
                throw new ParseException("Incorrect expression", tokenizer.getExpression());
        }
        return result;
    }
}
