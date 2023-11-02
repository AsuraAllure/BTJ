package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestArrays {
    @Test
    public void testAttachedArrays(){
        Assertions.assertTrue(Arrays.attachedArray(new int[] {1, 2, 3, 4}, new int[] {0, 6}));
        Assertions.assertTrue(Arrays.attachedArray(new int[] {3, 1}, new int[] {4, 0}));
        Assertions.assertFalse(Arrays.attachedArray(new int[] {9,9,8},  new int[] {8, 9}));
        Assertions.assertFalse(Arrays.attachedArray(new int[] {1, 2, 3, 4},  new int[] {2,3}));
        Assertions.assertFalse(Arrays.attachedArray(new int[] {1, 2, 3, 4},  new int[] {} ));
        Assertions.assertTrue(Arrays.attachedArray(new int[] {},  new int[] {2,3}));
    }
}
