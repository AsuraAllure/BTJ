package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {
    private AtomicLong count = new AtomicLong(0);

    public Counter() {
    }

    public long getValue() {
        return count.longValue();
    }

    public void increment() {
        count.addAndGet(1);
    }
}
