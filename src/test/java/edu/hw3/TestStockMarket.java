package edu.hw3;

import edu.hw3.StockMarket.AsuraStockMarket;
import edu.hw3.StockMarket.StockMarket;
import edu.hw3.StockMarket.StockMarket.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStockMarket {
    @Test
    public void testAsuraMarket() {
        StockMarket market = new AsuraStockMarket();
        market.add(new Stock(100, "SNT"));
        market.add(new Stock(150, "PBK"));
        market.add(new Stock(50, "RTL"));
        Assertions.assertEquals(new Stock(150, "PBK"), market.mostValuableStock());

        market.add(new Stock(250, "RS"));
        market.add(new Stock(100, "RS"));
        Assertions.assertEquals(new Stock(250, "RS"), market.mostValuableStock());

    }
}
