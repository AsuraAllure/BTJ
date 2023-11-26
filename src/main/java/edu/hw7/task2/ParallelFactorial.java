package edu.hw7.task2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ParallelFactorial {
    private ParallelFactorial() {

    }

    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n <= 1) {
            return BigInteger.ONE;
        }
        List<BigInteger> factList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            factList.add(BigInteger.valueOf(i));
        }
        return factList.stream().parallel().reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
