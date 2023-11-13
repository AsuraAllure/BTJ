package edu.hw5.task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask5 {

    @Test
    public void testSuccess() {
        Assertions.assertTrue(ExtraRegex.task5.matcher("").find());
        Assertions.assertTrue(ExtraRegex.task5.matcher("1").find());
        Assertions.assertTrue(ExtraRegex.task5.matcher("101").find());
        Assertions.assertTrue(ExtraRegex.task5.matcher("10").find());
        Assertions.assertTrue(ExtraRegex.task5.matcher("101").find());
        Assertions.assertTrue(ExtraRegex.task5.matcher("101111111").find());
        Assertions.assertTrue(ExtraRegex.task5.matcher("1010").find());
        Assertions.assertTrue(ExtraRegex.task5.matcher("101110").find());
        Assertions.assertTrue(ExtraRegex.task5.matcher("10101").find());
        Assertions.assertTrue(ExtraRegex.task5.matcher("1010111010").find());
        Assertions.assertTrue(ExtraRegex.task5.matcher("1111").find());
    }

    @Test
    public void testFail() {
        Assertions.assertFalse(ExtraRegex.task3.matcher("00").find());
        Assertions.assertFalse(ExtraRegex.task3.matcher("010").find());
        Assertions.assertFalse(ExtraRegex.task3.matcher("1010001").find());
        Assertions.assertFalse(ExtraRegex.task3.matcher("0010010").find());
        Assertions.assertFalse(ExtraRegex.task3.matcher("10100101110010").find());
    }
}
