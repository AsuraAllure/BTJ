package edu.hw3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRomeConvert {
    @Test
    public void testConvert() {
        Assertions.assertEquals("M", RomeNumber.toRomeNumber(1000));
        Assertions.assertEquals("MM", RomeNumber.toRomeNumber(2000));
        Assertions.assertEquals("MMM", RomeNumber.toRomeNumber(3000));
        Assertions.assertEquals("CM", RomeNumber.toRomeNumber(900));
        Assertions.assertEquals("MCM", RomeNumber.toRomeNumber(1900));
        Assertions.assertEquals("MMCM", RomeNumber.toRomeNumber(2900));
        Assertions.assertEquals("II", RomeNumber.toRomeNumber(2));
        Assertions.assertEquals("IV", RomeNumber.toRomeNumber(4));
        Assertions.assertEquals("V", RomeNumber.toRomeNumber(5));
        Assertions.assertEquals("VI", RomeNumber.toRomeNumber(6));
        Assertions.assertEquals("XII", RomeNumber.toRomeNumber(12));
        Assertions.assertEquals("XVI", RomeNumber.toRomeNumber(16));
        Assertions.assertEquals("XLIX", RomeNumber.toRomeNumber(49));
        Assertions.assertEquals("MDCCCXCIX", RomeNumber.toRomeNumber(1899));
    }
}
