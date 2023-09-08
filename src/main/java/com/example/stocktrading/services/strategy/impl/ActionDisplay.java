package com.example.stocktrading.services.strategy.impl;

import com.example.stocktrading.model.Stock;
import com.example.stocktrading.services.StockService;
import com.example.stocktrading.services.strategy.Action;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActionDisplay implements Action {
    private StockService stockService;

    private static final String COMMAND = "show";

    @Override
    public String apply(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/////////////");
        for (Stock stock : stockService.getStocks()) {
            stringBuilder
                    .append("\n")
                    .append(stock.getStockSymbol().getId())
                    .append("| ")
                    .append(stock.getStockName())
                    .append("| $")
                    .append(stock.getPrice())
                    .append(" : ")
                    .append(stockService.getCount(stock));
        }
        stringBuilder.append("\n/////////////");
        return stringBuilder.toString();
    }

    @Override
    public boolean pick(String command) {
        return command.equals(COMMAND);
    }
}
