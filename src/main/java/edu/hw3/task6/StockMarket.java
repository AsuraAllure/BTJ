package edu.hw3.task6;

public interface StockMarket {
    void add(Stock st);

    Stock mostValuableStock();

    record Stock(double cost, String name) {
    }
}
