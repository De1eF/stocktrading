package com.example.stocktrading.services.strategy;

import com.example.stocktrading.exceptions.WrongCommandException;
import com.example.stocktrading.model.Command;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
@AllArgsConstructor
public class ActionStrategy {
    private List<Action> tradeActions;

    public String act(Command command) {
        for (Action action : tradeActions) {
            if (action.pick(command.getCommand())) {
                return action.apply(command.getArgs());
            }
        }
        throw new WrongCommandException("Command not found");
    }
}
