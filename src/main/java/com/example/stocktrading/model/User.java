package com.example.stocktrading.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String username;
    private Double balance;
    private List<Trade> portfolio;
}
