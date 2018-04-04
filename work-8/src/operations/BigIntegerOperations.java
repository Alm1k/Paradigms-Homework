package operations;

import operations.exceptions.IllegalOperationException;
import operations.exceptions.OverflowException;

import java.math.BigInteger;

public class BigIntegerOperations implements Operations<BigInteger> {
    @Override
    public BigInteger parseNumber(String str) throws NumberFormatException {
        return new BigInteger(str);
    }

    @Override
    public BigInteger add(BigInteger first, BigInteger second) throws OverflowException {
        return first.add(second);
    }

    @Override
    public BigInteger subtract(BigInteger first, BigInteger second) throws OverflowException {
        return first.subtract(second);
    }

    @Override
    public BigInteger multiply(BigInteger first, BigInteger second) throws OverflowException {
        return first.multiply(second);
    }

    @Override
    public BigInteger divide(BigInteger first, BigInteger second) throws IllegalOperationException {
        return first.divide(second);
    }

    @Override
    public BigInteger negate(BigInteger value) throws OverflowException {
        return value.negate();
    }
}
