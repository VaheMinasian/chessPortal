package com.vahe.web.chessPortal;

public interface UserService {

    User getUser(String username);

    void saveUser(User user);
}
