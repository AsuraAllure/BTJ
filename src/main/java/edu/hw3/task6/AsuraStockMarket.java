package edu.hw3.task6;

import java.util.PriorityQueue;

public class AsuraStockMarket implements StockMarket {
    private final PriorityQueue<Stock> queue = new PriorityQueue<>(
        (st1, st2) -> -Double.compare(st1.cost(), st2.cost())
    );

    @Override
    public void add(Stock st) {
        queue.add(st);
    }

    @Override
    public Stock mostValuableStock() {
        return queue.peek();
    }
}
