package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestKaaprekar {
    @Test
    public void kaprekar(){
        Assertions.assertEquals(0, Kaprekar.kaprekarNumber(6174));
        Assertions.assertEquals(3, Kaprekar.kaprekarNumber(3524));
        Assertions.assertEquals(5, Kaprekar.kaprekarNumber(6621));
        Assertions.assertEquals(4, Kaprekar.kaprekarNumber(6554));
        Assertions.assertEquals(3, Kaprekar.kaprekarNumber(1234));
    }
}
