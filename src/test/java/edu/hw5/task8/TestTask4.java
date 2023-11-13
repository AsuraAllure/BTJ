package edu.hw5.task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask4 {
    @Test
    public void testSuccess() {
        Assertions.assertTrue(ExtraRegex.task4.matcher("").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("0").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("000").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("10").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("00").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("001").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("000").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("101101110").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("0010").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("101100").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("00101").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("1010010010").find());
        Assertions.assertTrue(ExtraRegex.task4.matcher("1111").find());
    }

    @Test
    public void testFail() {
        Assertions.assertFalse(ExtraRegex.task4.matcher("11").find());
        Assertions.assertFalse(ExtraRegex.task4.matcher("111").find());
    }
}
