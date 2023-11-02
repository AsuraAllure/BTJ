package edu.hw1;

public class Video {

    private static final int countSecondInMinute = 60;

    public static int lengthVideo(String input) {
        int lengthInput = input.length();
        if (lengthInput < 5) {
            return -1;
        }
        if (input.charAt(lengthInput - 3) != ':') {
            return -1;
        }
        int countMinutes, countSecond;

        try {
            countSecond = Integer.parseInt(input.substring(lengthInput - 2, lengthInput));
            if (countSecond > countSecondInMinute) {
                throw new NumberFormatException();
            }
            countMinutes = Integer.parseInt(input.substring(0, lengthInput - 3));
        } catch (NumberFormatException a) {
            return -1;
        }

        return countSecond + countSecondInMinute * countMinutes;
    }
}
