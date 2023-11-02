package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kaprekar {

    public static int kaprekarNumber(int n){
        if (n < 1000 || n > 9999)
            return -1;

        char[] digits = Integer.toString(n).toCharArray();

        for(int i = 0; i < 3; i++)
            for(int j = 1; j < 4; j++)
                if (i != j)
                    if (digits[i] != digits[j]) {
                        return countKaprekar(n);
                    }
        return -1;
    }

    private static int countKaprekar(int a){
        if (a == 6174)
            return 0;

        List<Integer> digits = new ArrayList<>(
            Integer.
                toString(a).
                chars().
                boxed().
                sorted().
                toList()
        );
        Integer inc = digits.stream().reduce((r, s) -> 10*r + s).orElse(-1);
        Collections.reverse(digits);
        Integer dec = digits.stream().reduce((r, s) -> 10 * r + s).orElse(-1);

        if (inc == -1 || dec == -1)
            return -1;
        return countKaprekar(dec - inc) + 1;
    }
}
