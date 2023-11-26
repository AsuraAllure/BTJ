package edu.hw7.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

class ParallelFactorialTest {

    @Test
    void factorial() {
        Assertions.assertEquals(BigInteger.ONE, ParallelFactorial.factorial(0));
        Assertions.assertEquals(BigInteger.ONE, ParallelFactorial.factorial(1));
        Assertions.assertEquals(BigInteger.valueOf(2), ParallelFactorial.factorial(2));
        Assertions.assertEquals(BigInteger.valueOf(6), ParallelFactorial.factorial(3));
        Assertions.assertEquals(BigInteger.valueOf(3628800), ParallelFactorial.factorial(10));
    }

    @Test
    void shouldThrowExc(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> ParallelFactorial.factorial(-1));
    }
}
