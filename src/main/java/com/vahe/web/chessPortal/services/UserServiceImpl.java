package com.vahe.web.chessPortal.services;

import javax.enterprise.context.ApplicationScoped;

import com.vahe.web.chessPortal.javaBeans.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    private final Map<String, User> users = new ConcurrentHashMap<>();

    @Override
    public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public void saveUser(User user) {
        users.put(user.getUsername(), user);
    }
}
