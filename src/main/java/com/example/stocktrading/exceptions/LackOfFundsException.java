package com.example.stocktrading.exceptions;

public class LackOfFundsException extends RuntimeException {
    public LackOfFundsException(String message) {
        super(message);
    }
}
