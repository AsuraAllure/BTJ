package edu.hw7.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MonteCarloPiTest {

    @Test
    void findPI() {
        MonteCarloPi m1 = new MonteCarloPi(1, 1000000);
        Assertions.assertTrue(Math.abs(Math.PI - m1.findPI()) < 0.5);
    }

    @Test
    void shouldThrowExc() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MonteCarloPi(0, 124));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MonteCarloPi(0, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MonteCarloPi(125, 0));
    }
}
