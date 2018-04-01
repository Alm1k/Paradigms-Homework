package expression.exceptions.operands;

public class OverflowException extends EvalException {
    public OverflowException() {
        super("overflow");
    }
}
