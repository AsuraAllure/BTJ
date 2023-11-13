package edu.hw5.task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask3 {
    @Test
    public void testSuccess() {
        Assertions.assertTrue(ExtraRegex.task3.matcher("000").find());
        Assertions.assertTrue(ExtraRegex.task3.matcher("101101110").find());
        Assertions.assertTrue(ExtraRegex.task3.matcher("0010").find());
        Assertions.assertTrue(ExtraRegex.task3.matcher("101100").find());
        Assertions.assertTrue(ExtraRegex.task3.matcher("00101").find());
        Assertions.assertTrue(ExtraRegex.task3.matcher("1010010010").find());
        Assertions.assertTrue(ExtraRegex.task3.matcher("").find());
        Assertions.assertTrue(ExtraRegex.task3.matcher("1111").find());
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
