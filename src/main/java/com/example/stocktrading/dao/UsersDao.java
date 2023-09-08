package com.example.stocktrading.dao;

import com.example.stocktrading.model.Stock;
import com.example.stocktrading.model.StockSymbol;
import com.example.stocktrading.model.User;
import java.util.List;

public interface UsersDao {
    User getUser(Integer index);

    void addUser(User user);

    void updateUser(Integer index, User user);
}
