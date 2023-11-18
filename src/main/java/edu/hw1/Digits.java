package edu.hw1;

public class Digits {
    private Digits() {
    }

    public static int countDigit(int number) {
        int num = Math.abs(number);

        int countDigit = 0;
        if (num == 0) {
            countDigit++;
        }
        final int NEXT_DIGIT_DIVIDER = 10;

        while (num > 0) {
            num /= NEXT_DIGIT_DIVIDER;
            countDigit++;
        }
        return countDigit;
    }
}
