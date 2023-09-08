package com.example.stocktrading.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Command {
    private String command;
    private String[] args;
}
