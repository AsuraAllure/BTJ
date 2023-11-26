package edu.hw7.task4;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class CalculateMonteCarlo implements Callable<Double> {
    private final int TOTAL_COUNT;
    private final static int FOUR = 4;

    public CalculateMonteCarlo(int countPoint) {
        TOTAL_COUNT = countPoint;
    }

    @Override
    public Double call() {
        int countHit = 0;
        for (int i = 0; i < TOTAL_COUNT; i++) {
            Point p = new Point(
                ThreadLocalRandom.current().nextDouble(2),
                ThreadLocalRandom.current().nextDouble(2)
            );

            if (Math.sqrt(Math.pow(p.x - 1, 2) + Math.pow(p.y - 1, 2)) <= 1) {
                countHit++;
            }
        }
        if (TOTAL_COUNT <= 0) {
            return 0.0;
        } else {
            return FOUR * ((double) countHit / TOTAL_COUNT);
        }
    }

    private record Point(double x, double y) {
    }
}
