package edu.hw5.task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask7 {
    @Test
    public void testSuccess() {
        Assertions.assertTrue(ExtraRegex.task7.matcher("").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("0").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("1").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("100").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("001").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("10000").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("0000100").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("010").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("10101010101").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("01").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("1010101010001010").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("0010101010").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("000000010000100001000000000100000000").find());
        Assertions.assertTrue(ExtraRegex.task7.matcher("000000000000").find());
    }

    @Test
    public void testFail() {
        Assertions.assertFalse(ExtraRegex.task7.matcher("11").find());
        Assertions.assertFalse(ExtraRegex.task7.matcher("1111").find());
        Assertions.assertFalse(ExtraRegex.task7.matcher("011").find());
        Assertions.assertFalse(ExtraRegex.task7.matcher("00011000").find());
    }
}
