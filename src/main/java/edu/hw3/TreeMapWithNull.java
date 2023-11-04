package edu.hw3;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapWithNull {
    public static void main(String[] args) {
        TreeMap<String, String> tree = new TreeMap<>(Comparator.nullsFirst(Comparator.naturalOrder()));

        tree.put(null, "test");
        if (tree.containsKey(null)) {
            System.out.println("Have Null");
        }
    }
}
