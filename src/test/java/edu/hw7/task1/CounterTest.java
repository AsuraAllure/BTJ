package edu.hw7.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CounterTest {

    @Test
    void increment() {
        Counter c = new Counter();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                for (int i1 = 0; i1 < 100000; i1++) {
                    c.increment();
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Assertions.fail();
        }
        Assertions.assertEquals(1000000, c.getValue());
    }
}
