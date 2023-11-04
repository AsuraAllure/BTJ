package edu.hw3;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Cluster {
    public static String[] clusterize(String source) {
        if (source.length() == 0) {
            return new String[0];
        }

        Stack<Character> stack = new Stack<>();
        List<String> clusters = new LinkedList<>();
        StringBuilder cluster = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            cluster.append(c);
            switch (c) {
                case '(' -> stack.push('(');
                case ')' -> stack.pop();
            }

            if (stack.empty()) {
                clusters.add(cluster.toString());
                cluster = new StringBuilder();
            }

        }
        return clusters.toArray(new String[0]);
    }
}
