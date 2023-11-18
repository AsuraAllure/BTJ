package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDigit {
    @Test
    public void countDigit() {
        Assertions.assertEquals(3, Digits.countDigit(125));
        Assertions.assertEquals(1, Digits.countDigit(0));
        Assertions.assertEquals(1, Digits.countDigit(1));
        Assertions.assertEquals(3, Digits.countDigit(-125));
    }
}
