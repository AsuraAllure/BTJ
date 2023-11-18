package edu.hw1;

import java.util.ArrayList;
import java.util.List;

public class Rotator {
    private Rotator() {
    }

    public static int rotateRight(int a, int shift) {
        List<Integer> digits = new ArrayList<>(
            Integer
                .toBinaryString(a)
                .chars()
                .boxed()
                .map(Character::getNumericValue)
                .toList()
        );
        int result = 0;
        int curPower = digits.size() - (shift % digits.size());
        for (int i = 0; i < digits.size(); i += 1) {
            curPower -= 1;
            if (curPower < 0) {
                curPower = digits.size() - 1;
            }

            if (digits.get(i) == 1) {
                result += (int) Math.pow(2, curPower);
            }
        }
        return result;
    }

    public static int rotateLeft(int a, int shift) {
        return rotateRight(a, Integer.toBinaryString(a).length() - (shift % Integer.toBinaryString(a).length()));
    }
}
