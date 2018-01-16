package com.vahe.web.chessPortal.services;

import com.vahe.web.chessPortal.javaBeans.User;

public interface UserService {

    User getUser(String username);

    void saveUser(User user);
}
