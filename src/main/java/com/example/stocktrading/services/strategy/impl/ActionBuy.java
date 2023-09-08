package com.example.stocktrading.services.strategy.impl;

import com.example.stocktrading.exceptions.WrongCommandException;
import com.example.stocktrading.model.StockSymbol;
import com.example.stocktrading.services.StockService;
import com.example.stocktrading.services.UserService;
import com.example.stocktrading.services.strategy.Action;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActionBuy implements Action {
    private StockService stockService;
    private UserService userService;

    private static final String COMMAND = "buy";

    @Override
    public String apply(String[] args) {
        if (args.length != 3) {
            throw new WrongCommandException("Wrong command syntax. "
                    + "use \"buy (user id) (stock symbol) (quantity)\""
            );
        }
        stockService.buyStock(userService.getUser(Integer.parseInt(args[0])), new StockSymbol(Integer.parseInt(args[1])), Long.parseLong(args[2]));
        return "buy " + args[0];
    }

    @Override
    public boolean pick(String command) {
        return command.equals(COMMAND);
    }
}
