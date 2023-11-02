package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPolindrom {
    @Test
    public void specialPolindrom(){
        Assertions.assertTrue(Polindrom.isPolindromeDescendant("11211230"));
        Assertions.assertTrue(Polindrom.isPolindromeDescendant("13001120"));
        Assertions.assertTrue(Polindrom.isPolindromeDescendant("23336014"));
        Assertions.assertFalse(Polindrom.isPolindromeDescendant("1234"));

    }
}
