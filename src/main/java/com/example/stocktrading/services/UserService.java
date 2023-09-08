package com.example.stocktrading.services;

import com.example.stocktrading.model.User;

public interface UserService {
    User getUser(Integer index);

    void addUser(User user);
}
