package com.example.stocktrading.services.impl;

import com.example.stocktrading.dao.StocksDao;
import com.example.stocktrading.dao.UsersDao;
import com.example.stocktrading.services.CommandReader;
import com.example.stocktrading.services.StockService;
import com.example.stocktrading.services.UserService;
import com.example.stocktrading.services.strategy.ActionStrategy;
import com.example.stocktrading.util.CommandParser;
import com.example.stocktrading.util.DbInit;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommandReaderIml implements CommandReader,
        ApplicationListener<ApplicationReadyEvent> {
    private ActionStrategy actionStrategy;
    private StockService stocksService;
    private UserService usersService;

    @Override
    public void read() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                try {
                    System.out.println(
                            actionStrategy.act(
                                    CommandParser.parse(scanner.nextLine()
                                    )
                            )
                    );
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        DbInit.initStocks(stocksService);
        DbInit.initUsers(usersService);
        read();
    }
}
