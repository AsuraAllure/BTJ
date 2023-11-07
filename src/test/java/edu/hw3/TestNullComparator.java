package edu.hw3;

import java.util.TreeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNullComparator {

    @Test
    public void testTree() {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator<>());
        tree.put(null, "test");

        Assertions.assertTrue(tree.containsKey(null));
        Assertions.assertEquals("test", tree.get(null));
    }
}
