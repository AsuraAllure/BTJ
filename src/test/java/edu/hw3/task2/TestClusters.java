package edu.hw3.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestClusters {

    @Test
    public void shouldThrowNullException() {
        NullPointerException exc = Assertions.assertThrows(NullPointerException.class, () -> Cluster.clusterize(null));
        Assertions.assertEquals(NullPointerException.class, exc.getClass());
    }

    @Test
    public void testCorrectClusterize() {
        Assertions.assertArrayEquals(new String[] {"()", "()", "()"}, Cluster.clusterize("()()()"));
        Assertions.assertArrayEquals(new String[] {"((()))"}, Cluster.clusterize("((()))"));
        Assertions.assertArrayEquals(
            new String[] {"((()))", "(())", "()", "()", "(()())"},
            Cluster.clusterize("((()))(())()()(()())")
        );
        Assertions.assertArrayEquals(new String[] {"((())())", "(()(()()))"}, Cluster.clusterize("((())())(()(()()))"));
    }
}
