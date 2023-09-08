package com.example.stocktrading.dao;

import com.example.stocktrading.model.Stock;
import com.example.stocktrading.model.StockSymbol;
import java.util.List;

public interface StocksDao {
    List<Stock> getAllTrades();

    Stock getByStockSymbol(StockSymbol stockSymbol);

    void updateStock(Stock stock, long quantity);

    Long countByStock(Stock stock);

    void putPosition(Stock stock);

    void removePosition(Stock stock);
}
