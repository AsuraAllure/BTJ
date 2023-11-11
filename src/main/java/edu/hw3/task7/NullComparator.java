package edu.hw3.task7;

import java.util.Comparator;

public class NullComparator<K extends Comparable<K>> implements Comparator<K> {
    @Override
    public int compare(K arg1, K arg2) {
        if (arg1 == null) {
            return 0;
        }

        return arg1.compareTo(arg2);
    }
}
