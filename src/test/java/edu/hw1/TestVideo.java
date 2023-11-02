package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestVideo {
    @Test
    public void videoLength() {
        Assertions.assertEquals(6700, Video.lengthVideo("111:40"));
        Assertions.assertEquals(-1, Video.lengthVideo("235sgdd:eg"));
        Assertions.assertEquals( -1,  Video.lengthVideo(""));
        Assertions.assertEquals(734, Video.lengthVideo("12:14"));
        Assertions.assertEquals(70, Video.lengthVideo("01:10"));
        Assertions.assertEquals(-1, Video.lengthVideo("01:70"));
    }
}
