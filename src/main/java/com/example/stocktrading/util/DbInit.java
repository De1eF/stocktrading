package com.example.stocktrading.util;

import com.example.stocktrading.dao.StocksDao;
import com.example.stocktrading.dao.UsersDao;
import com.example.stocktrading.model.Stock;
import com.example.stocktrading.model.StockSymbol;
import com.example.stocktrading.model.User;
import com.example.stocktrading.services.StockService;
import com.example.stocktrading.services.UserService;
import java.util.ArrayList;

public class DbInit {
    public static void initStocks(StockService service) {
        service.addStock
                (
                        new Stock(
                                "Toshiba",
                                new StockSymbol(0),
                                15.5
                        ), 10L
                );
        service.addStock
                (
                        new Stock(
                                "MSI",
                                new StockSymbol(1),
                                23.75
                        ), 10L
                );
    }

    public static void initUsers(UserService service) {
        service.addUser
                (
                        new User
                                (
                                        "Kea",
                                        500.00,
                                        new ArrayList<>()
                                )
                );
        service.addUser
                (
                        new User
                                (
                                        "Zija",
                                        500.00,
                                        new ArrayList<>()
                                )
                );
    }
}
