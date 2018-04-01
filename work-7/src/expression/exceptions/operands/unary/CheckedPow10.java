package expression.exceptions.operands.unary;

import expression.exceptions.TripleExpression;
import expression.exceptions.operands.EvalException;
import expression.exceptions.operands.IllegalOperationException;

public class CheckedPow10 extends CheckedUnary {
    public CheckedPow10(TripleExpression expression) {
        super(expression);
    }

    @Override
    void check(int result) throws EvalException {
        if (result < 0) {
            throw new IllegalOperationException("Powering is negative");
        }
    }

    @Override
    int apply(int result) {
        return (int) Math.pow(10, result);
    }
}
