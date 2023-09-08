package com.example.stocktrading.services.strategy.impl;

import com.example.stocktrading.exceptions.WrongCommandException;
import com.example.stocktrading.services.UserService;
import com.example.stocktrading.services.strategy.Action;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActionDisplayHelp implements Action {
    private UserService userService;

    private static final String COMMAND = "help";

    @Override
    public String apply(String[] args) {
        if (args.length != 0) {
            throw new WrongCommandException("Wrong command syntax. "
                    + "use \"help\""
            );
        }
        return "Command List"
                + "\n user (user id) - displays a user"
                + "\n show - displays the market"
                + "\n buy (user id) (stock symbol id) (quantity) - buys a stock for you"
                + "\n sell (user id) (stock symbol id) (quantity) - sells a stock for you";
    }

    @Override
    public boolean pick(String command) {
        return command.equals(COMMAND);
    }
}
