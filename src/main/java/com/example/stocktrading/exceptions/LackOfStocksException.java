package com.example.stocktrading.exceptions;

public class LackOfStocksException extends RuntimeException {
    public LackOfStocksException(String message) {
        super(message);
    }
}
