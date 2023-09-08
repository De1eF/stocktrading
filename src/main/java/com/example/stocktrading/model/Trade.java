package com.example.stocktrading.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trade {
    private Object stockSymbol;
    private TradeType tradeType;
    private Long quantity;
}

