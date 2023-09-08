package com.example.stocktrading.services.impl;

import com.example.stocktrading.dao.UsersDao;
import com.example.stocktrading.model.User;
import com.example.stocktrading.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UsersDao usersDao;

    @Override
    public User getUser(Integer index) {
        return usersDao.getUser(index);
    }

    @Override
    public void addUser(User user) {
        usersDao.addUser(user);
    }
}
