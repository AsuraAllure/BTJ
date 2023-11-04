package edu.hw3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestClusters {
    @Test
    public void testClusterize() {
        Assertions.assertArrayEquals(new String[] {"()", "()", "()"}, Cluster.clusterize("()()()"));
        Assertions.assertArrayEquals(new String[] {"((()))"}, Cluster.clusterize("((()))"));
        Assertions.assertArrayEquals(
            new String[] {"((()))", "(())", "()", "()", "(()())"},
            Cluster.clusterize("((()))(())()()(()())")
        );
        Assertions.assertArrayEquals(new String[] {"((())())", "(()(()()))"}, Cluster.clusterize("((())())(()(()()))"));
    }
}
