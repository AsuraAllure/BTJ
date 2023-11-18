package edu.hw3.task2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Cluster {
    private static final String[] EMPTY_LIST = new String[0];

    private Cluster() {

    }

    public static String[] clusterize(String source) {
        if (source == null) {
            throw new NullPointerException();
        }

        if (source.length() == 0) {
            return EMPTY_LIST;
        }

        Deque<Character> stack = new ArrayDeque<>();
        List<String> clusters = new ArrayList<>();
        StringBuilder cluster = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            cluster.append(c);
            switch (c) {
                case '(' -> stack.push('(');
                case ')' -> stack.pop();
                default -> {
                }
            }

            if (stack.isEmpty()) {
                clusters.add(cluster.toString());
                cluster = new StringBuilder();
            }

        }
        return clusters.toArray(new String[0]);
    }
}
