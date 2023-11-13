package edu.hw5.task6;

import java.util.regex.Pattern;

public class Substring {
    private Substring() {
    }

    public static boolean substr(String S, String T) {
        Pattern p = Pattern.compile(S);
        return p.matcher(T).find();
    }
}
