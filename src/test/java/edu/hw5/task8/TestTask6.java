package edu.hw5.task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask6 {
    @Test
    public void testSuccess() {
        Assertions.assertTrue(ExtraRegex.task6.matcher("00").find());
        Assertions.assertTrue(ExtraRegex.task6.matcher("000").find());
        Assertions.assertTrue(ExtraRegex.task6.matcher("001").find());
        Assertions.assertTrue(ExtraRegex.task6.matcher("100").find());
        Assertions.assertTrue(ExtraRegex.task6.matcher("010").find());
        Assertions.assertTrue(ExtraRegex.task6.matcher("10000").find());
        Assertions.assertTrue(ExtraRegex.task6.matcher("0000100").find());
    }

    @Test
    public void testFail() {
        Assertions.assertFalse(ExtraRegex.task6.matcher("").find());
        Assertions.assertFalse(ExtraRegex.task6.matcher("0").find());
        Assertions.assertFalse(ExtraRegex.task6.matcher("11").find());
        Assertions.assertFalse(ExtraRegex.task6.matcher("111000").find());
        Assertions.assertFalse(ExtraRegex.task6.matcher("011").find());
    }
}
