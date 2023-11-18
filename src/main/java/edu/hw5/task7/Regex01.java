package edu.hw5.task7;

import java.util.regex.Pattern;

public class Regex01 {
    public static Pattern task1 = Pattern.compile("^[01]{2}0[01]*");
    public static Pattern task2 = Pattern.compile("^([01])[01]*\\1$");
    public static Pattern task3 = Pattern.compile("^[01]{1,3}$");

    private Regex01() {
    }

}
