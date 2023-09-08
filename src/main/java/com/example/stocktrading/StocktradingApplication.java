package com.example.stocktrading;

import com.example.stocktrading.services.CommandReader;
import com.example.stocktrading.services.strategy.ActionStrategy;
import java.util.Arrays;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StocktradingApplication{
    @Autowired
    private CommandReader commandReader;

    public static void main(String[] args) {
        SpringApplication.run(StocktradingApplication.class, args);
    }
}
