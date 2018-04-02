package expression.exceptions.operands.unary;

import expression.exceptions.TripleExpression;
import expression.exceptions.operands.EvalException;
import expression.exceptions.operands.IllegalOperationException;

public class CheckedLog10 extends CheckedUnary {
    public CheckedLog10(TripleExpression expression) {
        super(expression);
    }

    @Override
    void check(int value) throws EvalException {
        if (value <= 0) {
            throw new IllegalOperationException("Log form negative");
        }
    }

    @Override
    int apply(int value) {
        return (int) Math.log10(value);
    }
}
