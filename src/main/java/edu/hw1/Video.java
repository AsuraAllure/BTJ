package edu.hw1;

public class Video {
    private static final int COUNT_SECOND_PER_MINUTE = 60;
    private static final int FAIL_CODE = 1;

    private Video() {
    }

    public static int lengthVideo(String input) {
        int lengthInput = input.length();

        final int MIN_LENGTH_INPUT = 5;
        if (lengthInput < MIN_LENGTH_INPUT) {
            return FAIL_CODE;
        }

        final int OFFSET_TO_SEPARATOR = 3;
        if (input.charAt(lengthInput - OFFSET_TO_SEPARATOR) != ':') {
            return FAIL_CODE;
        }
        int countMinutes, countSecond;

        try {
            countSecond = Integer.parseInt(input.substring(lengthInput - 2, lengthInput));
            if (countSecond > COUNT_SECOND_PER_MINUTE) {
                throw new NumberFormatException();
            }
            countMinutes = Integer.parseInt(input.substring(0, lengthInput - 3));
        } catch (NumberFormatException ex) {
            return FAIL_CODE;
        }

        return countSecond + COUNT_SECOND_PER_MINUTE * countMinutes;
    }
}
