package edu.hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CallingTest {
    @Test
    public void testCall() {
        Assertions.assertEquals(new Calling.CallingInfo("edu.hw2.CallingTest", "testCall"), Calling.call());
    }
}
