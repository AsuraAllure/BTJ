package edu.hw5.task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask1 {
    @Test
    public void testSuccess() {
        Assertions.assertTrue(Regex01.task1.matcher("000").find());
        Assertions.assertTrue(Regex01.task1.matcher("010").find());
        Assertions.assertTrue(Regex01.task1.matcher("100").find());
        Assertions.assertTrue(Regex01.task1.matcher("110").find());

        Assertions.assertTrue(Regex01.task1.matcher("0000").find());
        Assertions.assertTrue(Regex01.task1.matcher("0101").find());
        Assertions.assertTrue(Regex01.task1.matcher("10011").find());
        Assertions.assertTrue(Regex01.task1.matcher("11000").find());
        Assertions.assertTrue(Regex01.task1.matcher("000000").find());
        Assertions.assertTrue(Regex01.task1.matcher("0101111").find());
        Assertions.assertTrue(Regex01.task1.matcher("10011111").find());
        Assertions.assertTrue(Regex01.task1.matcher("11000000").find());
    }

    @Test
    public void testFail() {
        Assertions.assertFalse(Regex01.task1.matcher("").find());
        Assertions.assertFalse(Regex01.task1.matcher("0").find());
        Assertions.assertFalse(Regex01.task1.matcher("1").find());
        Assertions.assertFalse(Regex01.task1.matcher("00").find());
        Assertions.assertFalse(Regex01.task1.matcher("01").find());
        Assertions.assertFalse(Regex01.task1.matcher("10").find());
        Assertions.assertFalse(Regex01.task1.matcher("11").find());

        Assertions.assertFalse(Regex01.task1.matcher("001").find());
        Assertions.assertFalse(Regex01.task1.matcher("011").find());
        Assertions.assertFalse(Regex01.task1.matcher("101").find());
        Assertions.assertFalse(Regex01.task1.matcher("111").find());

        Assertions.assertFalse(Regex01.task1.matcher("00100").find());
        Assertions.assertFalse(Regex01.task1.matcher("01100").find());
        Assertions.assertFalse(Regex01.task1.matcher("10110").find());
        Assertions.assertFalse(Regex01.task1.matcher("1110000").find());
    }
}
