package com.example.stocktrading.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stock {
    private String stockName;
    private StockSymbol stockSymbol;
    private Double price;
}
