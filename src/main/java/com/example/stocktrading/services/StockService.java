package com.example.stocktrading.services;

import com.example.stocktrading.model.Stock;
import com.example.stocktrading.model.StockSymbol;
import com.example.stocktrading.model.User;
import java.util.List;

public interface StockService {
    List<Stock> getStocks();

    Long getCount(Stock stock);

    void addStock(Stock stock, Long amount);

    boolean buyStock(
            User user,
            StockSymbol stockSymbol,
            Long quantity
    );

    boolean sellStock(
            User user,
            StockSymbol stockSymbol,
            Long quantity
    );
}
