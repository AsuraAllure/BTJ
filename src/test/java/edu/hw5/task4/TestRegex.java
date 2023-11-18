package edu.hw5.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRegex {
    @Test
    public void testSuccess() {
        String[] reqSymbol = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "|"};
        for (var el : reqSymbol) {
            Assertions.assertTrue(PasswordRegex.regex.matcher(String.format("asd%s", el)).find());
            Assertions.assertTrue(PasswordRegex.regex.matcher(String.format("%sasd", el)).find());
            Assertions.assertTrue(PasswordRegex.regex.matcher(String.format("asd%sasd", el)).find());
            Assertions.assertTrue(PasswordRegex.regex.matcher(String.format("%s", el)).find());
        }
    }

    @Test
    public void testFail() {
        Assertions.assertFalse(PasswordRegex.regex.matcher("asdrofmb").find());
        Assertions.assertFalse(PasswordRegex.regex.matcher("as").find());
        Assertions.assertFalse(PasswordRegex.regex.matcher("").find());
        Assertions.assertFalse(PasswordRegex.regex.matcher("a").find());
    }

}
