package edu.hw5.task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSubstr {
    @Test
    public void testSuccess() {
        Assertions.assertTrue(Substring.substr("abc", "achfdbaabgabcaabg"));
        Assertions.assertTrue(Substring.substr("abr", "abracadabra"));
        Assertions.assertTrue(Substring.substr("", "abracadabra"));
        Assertions.assertTrue(Substring.substr("", ""));
    }

    @Test
    public void testFail() {
        Assertions.assertFalse(Substring.substr("abec", "achfdbaabgabcaabg"));
        Assertions.assertFalse(Substring.substr("abre", "abracadabra"));
        Assertions.assertFalse(Substring.substr("e", "abracadabra"));
        Assertions.assertFalse(Substring.substr("e", ""));
    }
}
