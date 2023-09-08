package com.example.stocktrading.dao.impl;

import com.example.stocktrading.dao.UsersDao;
import com.example.stocktrading.model.User;
import com.example.stocktrading.util.UsersDB;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsersDaoImpl implements UsersDao {
    private UsersDB usersDB;

    @Override
    public User getUser(Integer index) {
        return usersDB.getBase().get(index);
    }

    @Override
    public void addUser(User user) {
        usersDB.getBase().add(user);
    }

    @Override
    public void updateUser(Integer index, User user) {
        usersDB.getBase().add(index, user);
    }
}
