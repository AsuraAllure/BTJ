package edu.hw5.task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTask3 {
    @Test
    public void testSuccess(){
        Assertions.assertTrue(Regex01.task3.matcher("1").find());
        Assertions.assertTrue(Regex01.task3.matcher("0").find());
        Assertions.assertTrue(Regex01.task3.matcher("10").find());
        Assertions.assertTrue(Regex01.task3.matcher("01").find());
        Assertions.assertTrue(Regex01.task3.matcher("100").find());
        Assertions.assertTrue(Regex01.task3.matcher("101").find());
        Assertions.assertTrue(Regex01.task3.matcher("110").find());
        Assertions.assertTrue(Regex01.task3.matcher("111").find());
        Assertions.assertTrue(Regex01.task3.matcher("000").find());
        Assertions.assertTrue(Regex01.task3.matcher("001").find());
        Assertions.assertTrue(Regex01.task3.matcher("010").find());
        Assertions.assertTrue(Regex01.task3.matcher("011").find());
    }

    @Test
    public void testFail(){
        Assertions.assertFalse(Regex01.task3.matcher("").find());
        Assertions.assertFalse(Regex01.task3.matcher("0000").find());
        Assertions.assertFalse(Regex01.task3.matcher("1110").find());
        Assertions.assertFalse(Regex01.task3.matcher("1101").find());
        Assertions.assertFalse(Regex01.task3.matcher("1100").find());
        Assertions.assertFalse(Regex01.task3.matcher("0101").find());
        Assertions.assertFalse(Regex01.task3.matcher("0110").find());
        Assertions.assertFalse(Regex01.task3.matcher("1111").find());
        Assertions.assertFalse(Regex01.task3.matcher("0000").find());
        Assertions.assertFalse(Regex01.task3.matcher("11001").find());
        Assertions.assertFalse(Regex01.task3.matcher("00010").find());
        Assertions.assertFalse(Regex01.task3.matcher("1111011").find());
    }

}
