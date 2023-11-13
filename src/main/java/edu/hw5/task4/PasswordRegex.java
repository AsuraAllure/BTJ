package edu.hw5.task4;

import java.util.regex.Pattern;

public class PasswordRegex {
    public static Pattern regex = Pattern.compile(".*[~!@#$%^&*|]++.*");

    private PasswordRegex() {
    }
}
