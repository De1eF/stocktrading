package com.example.stocktrading.dao.impl;

import com.example.stocktrading.util.StocksDB;
import com.example.stocktrading.dao.StocksDao;
import com.example.stocktrading.model.Stock;
import com.example.stocktrading.model.StockSymbol;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class StocksDaoImpl implements StocksDao {
    private StocksDB stocksDB;

    @Override
    public List<Stock> getAllTrades() {
        return new ArrayList<>(stocksDB.getBase().keySet());
    }

    @Override
    public Stock getByStockSymbol(StockSymbol stockSymbol) {
        return stocksDB.getBase().keySet()
                .stream()
                .filter(s -> s.getStockSymbol().equals(stockSymbol))
                .findAny()
                .orElseThrow(() -> new RuntimeException("No such stock found"));
    }

    @Override
    public void updateStock(Stock stock, long quantity) {
        Stock fromDb = getByStockSymbol(stock.getStockSymbol());
        stocksDB.getBase().put(fromDb, stocksDB.getBase().get(fromDb) + quantity);
    }

    @Override
    public Long countByStock(Stock stock) {
        return stocksDB.getBase().get(stock);
    }

    @Override
    public void putPosition(Stock stock) {
        stocksDB.getBase().put(stock, 0L);
    }

    @Override
    public void removePosition(Stock stock) {
        stocksDB.getBase().remove(stock);
    }
}
