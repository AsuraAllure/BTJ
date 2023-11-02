package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRotator {
    @Test
    public void rightRotate(){
        Assertions.assertEquals(4, Rotator.rotateRight(8, 5));
        Assertions.assertEquals(1, Rotator.rotateRight(1, 5));
        Assertions.assertEquals(4, Rotator.rotateRight(8, 1));
        Assertions.assertEquals(1, Rotator.rotateRight(1, 1));
        Assertions.assertEquals(8, Rotator.rotateRight(16, 1));
        Assertions.assertEquals(12, Rotator.rotateRight(17, 2));
    }
    @Test
    public void leftRotate(){
        Assertions.assertEquals(1, Rotator.rotateLeft(16, 1));
        Assertions.assertEquals(1, Rotator.rotateLeft(16, 6));
        Assertions.assertEquals(6, Rotator.rotateLeft(17, 2));
    }
}
