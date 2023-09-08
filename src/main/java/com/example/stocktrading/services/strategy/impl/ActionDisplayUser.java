package com.example.stocktrading.services.strategy.impl;

import com.example.stocktrading.exceptions.WrongCommandException;
import com.example.stocktrading.model.StockSymbol;
import com.example.stocktrading.services.StockService;
import com.example.stocktrading.services.UserService;
import com.example.stocktrading.services.strategy.Action;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActionDisplayUser implements Action {
    private UserService userService;

    private static final String COMMAND = "user";

    @Override
    public String apply(String[] args) {
        if (args.length != 1) {
            throw new WrongCommandException("Wrong command syntax. "
                    + "use \"user (user id)\""
            );
        }
        return userService.getUser(Integer.parseInt(args[0])).toString();
    }

    @Override
    public boolean pick(String command) {
        return command.equals(COMMAND);
    }
}
