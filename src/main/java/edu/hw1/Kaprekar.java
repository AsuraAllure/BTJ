package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kaprekar {
    private static final int failCode = -1;
    private static final int kaprekarNumber = 6174;

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
        return failCode;
    }

    private static int countKaprekar(int a) {
        if (a == kaprekarNumber) {
            return 0;
        }

        List<Integer> digits = new ArrayList<>(
            Integer.
                toString(a)
                .chars()
                .boxed()
                .sorted()
                .toList()
        );
        Integer inc = digits.stream().reduce((r, s) -> 10 * r + s).orElse(failCode);
        Collections.reverse(digits);
        Integer dec = digits.stream().reduce((r, s) -> 10 * r + s).orElse(failCode);

        if (inc == failCode || dec == failCode) {
            return failCode;
        }
        return countKaprekar(dec - inc) + 1;
    }
}
