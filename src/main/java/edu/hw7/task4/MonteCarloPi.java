package edu.hw7.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MonteCarloPi {
    private final int countThread;
    private final int totalCount;

    public MonteCarloPi(int countThread, int totalCount) {
        if (countThread < 1 || totalCount < 1) {
            throw new IllegalArgumentException();
        }

        this.countThread = countThread;
        this.totalCount = totalCount;
    }

    public double findPI() {
        ExecutorService executor = Executors.newFixedThreadPool(countThread);
        List<Future<Double>> results = new ArrayList<>();

        int unusedThread = countThread + 1;
        int unusedCount = totalCount;
        for (int i = 0; i < countThread; i++) {
            if (unusedCount > 0) {
                unusedThread--;
            }
            if (unusedCount % unusedThread == 0) {
                results.add(executor.submit(new CalculateMonteCarlo(unusedCount / unusedThread)));
                unusedCount -= unusedCount / unusedThread;
            } else {
                results.add(executor.submit(new CalculateMonteCarlo((unusedCount / unusedThread) + 1)));
                unusedCount -= (unusedCount / unusedThread) + 1;
            }
        }

        double pi = 0;
        try {
            for (int j = 0; j < countThread - unusedThread + 1; j++) {
                pi += results.get(j).get();
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return pi / (countThread - unusedThread + 1);
    }
}
