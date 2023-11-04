package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class FrecDict {
    public static <E> Map<E, Integer> toFreqDict(E[] arr) {
        Map<E, Integer> dict = new HashMap<>();
        for (var obj : arr) {
            if (dict.containsKey(obj)) {
                dict.put(obj, dict.get(obj) + 1);
            } else {
                dict.put(obj, 1);
            }
        }
        return dict;
    }
}
