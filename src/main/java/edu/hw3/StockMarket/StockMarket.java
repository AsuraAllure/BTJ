package edu.hw3.StockMarket;

public interface StockMarket {
    void add(Stock st);

    void remove(Stock st);

    Stock mostValuableStock();

    record Stock(double cost, String name) {
    }
}
