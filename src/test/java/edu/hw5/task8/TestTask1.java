package edu.hw5.task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask1 {

    @Test
    public void testSuccess() {
        Assertions.assertTrue(ExtraRegex.task1.matcher("0").find());
        Assertions.assertTrue(ExtraRegex.task1.matcher("1").find());
        Assertions.assertTrue(ExtraRegex.task1.matcher("001").find());
        Assertions.assertTrue(ExtraRegex.task1.matcher("101").find());
        Assertions.assertTrue(ExtraRegex.task1.matcher("0010010").find());
        Assertions.assertTrue(ExtraRegex.task1.matcher("101001001").find());
    }

    @Test
    public void testFail() {
        Assertions.assertFalse(ExtraRegex.task1.matcher("").find());
        Assertions.assertFalse(ExtraRegex.task1.matcher("11").find());
        Assertions.assertFalse(ExtraRegex.task1.matcher("0010").find());
        Assertions.assertFalse(ExtraRegex.task1.matcher("101000").find());
        Assertions.assertFalse(ExtraRegex.task1.matcher("00100100").find());
        Assertions.assertFalse(ExtraRegex.task1.matcher("1010010101").find());
    }
}
