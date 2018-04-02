package expression.exceptions.operands.unary;

import expression.exceptions.TripleExpression;
import expression.exceptions.operands.EvalException;
import expression.exceptions.operands.OverflowException;

public class CheckedNegate extends CheckedUnary {
    public CheckedNegate(TripleExpression expression) {
        super(expression);
    }

    @Override
    void check(int value) throws EvalException {
        if (value == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
    }

    @Override
    int apply(int value) {
        return -value;
    }
}
