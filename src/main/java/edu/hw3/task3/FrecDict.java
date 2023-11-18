package edu.hw3.task3;

import java.util.HashMap;
import java.util.Map;

public class FrecDict {
    private FrecDict() {
    }

    public static <E> Map<E, Integer> toFreqDict(E[] arr) {
        if (arr == null) {
            throw new NullPointerException();
        }

        Map<E, Integer> dict = new HashMap<>();
        for (var obj : arr) {
            dict.put(obj, dict.getOrDefault(obj, 1));
        }
        return dict;
    }
}
