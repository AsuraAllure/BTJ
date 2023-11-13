package edu.hw5.task8;

import java.util.regex.Pattern;

public class ExtraRegex {
    public static Pattern task1 = Pattern.compile("^[01]([01]{2})*$");
    public static Pattern task2 = Pattern.compile("(^0([01]{2})*$|^1[01]([01]{2})*$)");
    public static Pattern task3 = Pattern.compile("^((1*0){3})*1*$");
    public static Pattern task4 = Pattern.compile("^(?!(11$|111$)).*$");
    public static Pattern task5 = Pattern.compile("^(1[01]?)*$");
    public static Pattern task6 = Pattern.compile("^(0*1?0{2,}|0+10+|0{2,}10*)$");
    public static Pattern task7 = Pattern.compile("^((0*(?!11)10*)*|0*)$");

    private ExtraRegex() {

    }
}
