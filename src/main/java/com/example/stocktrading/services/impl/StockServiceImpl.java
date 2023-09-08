package com.example.stocktrading.services.impl;

import com.example.stocktrading.dao.StocksDao;
import com.example.stocktrading.dao.UsersDao;
import com.example.stocktrading.exceptions.LackOfFundsException;
import com.example.stocktrading.exceptions.LackOfStocksException;
import com.example.stocktrading.model.Stock;
import com.example.stocktrading.model.StockSymbol;
import com.example.stocktrading.model.Trade;
import com.example.stocktrading.model.TradeType;
import com.example.stocktrading.model.User;
import com.example.stocktrading.services.StockService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StockServiceImpl implements StockService {
    private StocksDao stocksDao;

    @Override
    public List<Stock> getStocks() {
        return stocksDao.getAllTrades();
    }

    @Override
    public Long getCount(Stock stock) {
        return stocksDao.countByStock(stock);
    }

    @Override
    public void addStock(Stock stock, Long amount) {
        stocksDao.putPosition(stock);
        stocksDao.updateStock(stock, amount);
    }

    @Override
    public boolean buyStock(
            User user,
            StockSymbol stockSymbol,
            Long quantity) {
        Stock fromMarket = stocksDao.getByStockSymbol(stockSymbol);
        Long count = stocksDao.countByStock(fromMarket);
        if (count < quantity && count == 0) {
            throw new LackOfStocksException(
                    "There aren't enough stocks on the market "
                    + " reduce your appetite"
            );
        }
        if (fromMarket.getPrice() * quantity > user.getBalance()) {
            throw new LackOfFundsException(
                    "Not enough money on the balance, go get some cash you hobo"
            );
        }
        stocksDao.updateStock(fromMarket, -quantity);
        user.getPortfolio().add(new Trade(stockSymbol, TradeType.BUY, quantity));
        user.setBalance(user.getBalance() - quantity * fromMarket.getPrice());
        return true;
    }

    @Override
    public boolean sellStock(
            User user,
            StockSymbol stockSymbol,
            Long quantity
    ) {
        Stock fromMarket = stocksDao.getByStockSymbol(stockSymbol);
        long quantityBought = user.getPortfolio()
                .stream()
                .filter(
                        t ->
                                t.getStockSymbol().equals(stockSymbol) &&
                                        t.getTradeType() == TradeType.BUY
                ).mapToInt(t -> Math.toIntExact(t.getQuantity())).sum();
        long quantitySold = user.getPortfolio()
                .stream()
                .filter(
                        t ->
                                t.getStockSymbol().equals(stockSymbol) &&
                                        t.getTradeType() == TradeType.SELL
                ).mapToInt(t -> Math.toIntExact(t.getQuantity())).sum();
        long quantityTotal = quantityBought - quantitySold;
        if (quantityTotal < 1 ||
                quantityTotal < quantity) {
            throw new LackOfStocksException(
                    "Unable to sell this amount of stocks, either"
                    + " reduce your ambitions or buy more stocks");
        }
        stocksDao.updateStock(fromMarket, quantity);
        user.getPortfolio().add(new Trade(stockSymbol, TradeType.SELL, quantity));
        user.setBalance(user.getBalance() + quantity * fromMarket.getPrice());
        return true;
    }
}
