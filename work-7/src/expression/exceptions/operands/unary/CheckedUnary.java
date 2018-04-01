package expression.exceptions.operands.unary;

import expression.exceptions.TripleExpression;
import expression.exceptions.operands.EvalException;

public abstract class CheckedUnary implements TripleExpression {
    private TripleExpression expression;

    CheckedUnary(TripleExpression expression) {
        this.expression = expression;
    }

    @Override
    public int evaluate(int x, int y, int z) throws EvalException {
        int result = expression.evaluate(x, y, z);
        check(result);
        return apply(result);
    }

    abstract void check(int result) throws EvalException;

    abstract int apply(int result);
}
