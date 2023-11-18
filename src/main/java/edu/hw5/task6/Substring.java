package edu.hw5.task6;

import java.util.regex.Pattern;

public class Substring {
    private Substring() {
    }

    public static boolean substr(String s, String t) {
        Pattern p = Pattern.compile(s);
        return p.matcher(t).find();
    }
}
