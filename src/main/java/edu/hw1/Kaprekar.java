package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kaprekar {
    private static final int FAIL_CODE = -1;
    private static final int KAPREKAR_NUMBER = 6174;

    private Kaprekar() {
    }

    public static int kaprekarNumber(int n) {
        final int minFourDigitNumber = 1000;
        final int maxFourDigitNumber = 9999;

        if (n < minFourDigitNumber || n > maxFourDigitNumber) {
            return -1;
        }

        char[] digits = Integer
            .toString(n)
            .toCharArray();

        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = 1; j < digits.length; j++) {
                if (i != j) {
                    if (digits[i] != digits[j]) {
                        return countKaprekar(n);
                    }
                }
            }
        }
        return FAIL_CODE;
    }

    private static int countKaprekar(int a) {
        if (a == KAPREKAR_NUMBER) {
            return 0;
        }

        List<Integer> digits = new ArrayList<>(
            Integer
                .toString(a)
                .chars()
                .boxed()
                .sorted()
                .toList()
        );

        final int ORDER_MULTIPLIER = 10;
        Integer inc = digits.stream().reduce((r, s) -> ORDER_MULTIPLIER * r + s).orElse(FAIL_CODE);
        Collections.reverse(digits);
        Integer dec = digits.stream().reduce((r, s) -> ORDER_MULTIPLIER * r + s).orElse(FAIL_CODE);

        if (inc == FAIL_CODE || dec == FAIL_CODE) {
            return FAIL_CODE;
        }
        return countKaprekar(dec - inc) + 1;
    }
}
