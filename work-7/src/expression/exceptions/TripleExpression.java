package expression.exceptions;

import expression.exceptions.operands.EvalException;

public interface TripleExpression {
    int evaluate(int x, int y, int z) throws EvalException;
}
