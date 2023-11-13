package edu.hw5.task5;

import java.util.regex.Pattern;

public class CarIDRegex {
    static public Pattern carRegex = Pattern.compile(
        "^[АВЕКМНОРСТУХ](?!000)\\d{3}[АВЕКМНОРСТУХ]{2}([1-9]\\d{2}|(?!00)\\d{2})$",
        Pattern.UNICODE_CHARACTER_CLASS
    );

    private CarIDRegex() {
    }
}
