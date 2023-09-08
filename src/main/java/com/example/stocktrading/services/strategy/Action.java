package com.example.stocktrading.services.strategy;

public interface Action {

    String apply(String[] args);

    boolean pick(String command);
}
