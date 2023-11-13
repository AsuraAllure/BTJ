package edu.hw5.task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask2 {
    @Test
    public void testSuccess() {
        Assertions.assertTrue(ExtraRegex.task2.matcher("0").find());
        Assertions.assertTrue(ExtraRegex.task2.matcher("10").find());
        Assertions.assertTrue(ExtraRegex.task2.matcher("001").find());
        Assertions.assertTrue(ExtraRegex.task2.matcher("1011").find());
        Assertions.assertTrue(ExtraRegex.task2.matcher("0010010").find());
        Assertions.assertTrue(ExtraRegex.task2.matcher("1010010010").find());
    }

    @Test
    public void testFail() {
        Assertions.assertFalse(ExtraRegex.task2.matcher("").find());
        Assertions.assertFalse(ExtraRegex.task2.matcher("00").find());
        Assertions.assertFalse(ExtraRegex.task2.matcher("0010").find());
        Assertions.assertFalse(ExtraRegex.task2.matcher("1010001").find());
        Assertions.assertFalse(ExtraRegex.task2.matcher("00100100").find());
        Assertions.assertFalse(ExtraRegex.task2.matcher("10100101010").find());
    }
}
