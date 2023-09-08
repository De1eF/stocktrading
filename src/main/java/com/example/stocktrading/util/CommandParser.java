package com.example.stocktrading.util;

import com.example.stocktrading.exceptions.WrongCommandException;
import com.example.stocktrading.model.Command;

public class CommandParser {

    public static Command parse(String input) {
        String[] split = input.split(" ");
        if (split.length < 1) {
            throw new WrongCommandException("You must specify the command");
        }
        String[] args = new String[split.length - 1];
        System.arraycopy(split, 1, args, 0, split.length - 1);
        return new Command(split[0], args);
    }
}
