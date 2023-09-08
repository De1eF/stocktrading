package com.example.stocktrading.util;

import com.example.stocktrading.model.User;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UsersDB {
    private final List<User> base = new ArrayList<>();
}
