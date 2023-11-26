package edu.hw7.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateMonteCarloTest {

    @Test
    void call() {
        CalculateMonteCarlo m1 = new CalculateMonteCarlo(1000000);
        Assertions.assertTrue(Math.abs(Math.PI - m1.call()) < 0.5);
    }
}
