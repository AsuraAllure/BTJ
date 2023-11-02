package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBrokenString {
    @Test
    public void testBrokenString(){
        Assertions.assertEquals("214365", FixString.incorrectString("123456"));
        Assertions.assertEquals("This is a mixed up string.", FixString.incorrectString("hTsii  s aimex dpus rtni.g"));
        Assertions.assertEquals("abcde", FixString.incorrectString("badce"));
    }
}
