package edu.hw3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class TestFreqDict {
    @Test
    public void testFreq() {
        Map<String, Integer> m1 = FrecDict.toFreqDict(new String[] {"a", "bb", "a", "bb"});

        Assertions.assertEquals(2, m1.keySet().size());
        Assertions.assertEquals(2, m1.get("a"));
        Assertions.assertEquals(2, m1.get("bb"));

        Map<String, Integer> m2 = FrecDict.toFreqDict(new String[] {"this", "and", "that", "and"});

        Assertions.assertEquals(3, m2.keySet().size());
        Assertions.assertEquals(1, m2.get("this"));
        Assertions.assertEquals(2, m2.get("and"));
        Assertions.assertEquals(1, m2.get("that"));

        Map<String, Integer> m3 = FrecDict.toFreqDict(new String[] {"код", "код", "код", "bug"});

        Assertions.assertEquals(2, m3.keySet().size());
        Assertions.assertEquals(1, m3.get("bug"));
        Assertions.assertEquals(3, m3.get("код"));

        Map<Integer, Integer> m4 = FrecDict.toFreqDict(new Integer[] {1, 1, 2, 2});

        Assertions.assertEquals(2, m4.keySet().size());
        Assertions.assertEquals(2, m4.get(2));
        Assertions.assertEquals(2, m4.get(1));
    }
}
