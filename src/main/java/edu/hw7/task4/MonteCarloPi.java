package edu.hw7.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MonteCarloPi {
    private final int COUNT_THREAD;
    private final int TOTAL_COUNT;

    public MonteCarloPi(int countThread, int totalCount) {
        if (countThread < 1 || totalCount < 1) {
            throw new IllegalArgumentException();
        }

        COUNT_THREAD = countThread;
        TOTAL_COUNT = totalCount;
    }

    public double findPI() {
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);
        List<Future<Double>> results = new ArrayList<>();

        int unusedThread = COUNT_THREAD + 1;
        int unusedCount = TOTAL_COUNT;
        for (int i = 0; i < COUNT_THREAD; i++) {
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
            for (int j = 0; j < COUNT_THREAD - unusedThread + 1; j++) {
                pi += results.get(j).get();
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return pi / (COUNT_THREAD - unusedThread + 1);
    }
}
