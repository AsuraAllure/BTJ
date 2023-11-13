package edu.hw5.task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask2 {
    @Test
    public void testSuccess() {

        Assertions.assertTrue(Regex01.task2.matcher("101").find());
        Assertions.assertTrue(Regex01.task2.matcher("0010110").find());
        Assertions.assertTrue(Regex01.task2.matcher("10101111111").find());
        Assertions.assertTrue(Regex01.task2.matcher("00").find());
    }

    @Test
    public void testFail() {
        Assertions.assertFalse(Regex01.task2.matcher("").find());
        Assertions.assertFalse(Regex01.task2.matcher("0").find());
        Assertions.assertFalse(Regex01.task2.matcher("1").find());
        Assertions.assertFalse(Regex01.task2.matcher("01").find());
        Assertions.assertFalse(Regex01.task2.matcher("10").find());
        Assertions.assertFalse(Regex01.task2.matcher("1000").find());
        Assertions.assertFalse(Regex01.task2.matcher("0011").find());

        Assertions.assertFalse(Regex01.task2.matcher("001").find());
        Assertions.assertFalse(Regex01.task2.matcher("011").find());
        Assertions.assertFalse(Regex01.task2.matcher("1000").find());
        Assertions.assertFalse(Regex01.task2.matcher("00111").find());

    }
}
