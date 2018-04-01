package expression.exceptions.operands.unary;

import expression.exceptions.TripleExpression;
import expression.exceptions.operands.EvalException;
import expression.exceptions.operands.IllegalOperationException;

public class CheckedLog10 extends CheckedUnary {

    public CheckedLog10(TripleExpression expression) {
        super(expression);
    }

    @Override
    void check(int result) throws EvalException {
        if (result <= 0) {
            throw new IllegalOperationException("Log form negative");
        }
    }

    @Override
    int apply(int result) {
        return (int) Math.log10(result);
    }
}
