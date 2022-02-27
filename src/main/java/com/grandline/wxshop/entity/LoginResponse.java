package com.grandline.wxshop.entity;

import com.grandline.wxshop.generate.User;

public class LoginResponse {
    private boolean login;
    private User user;

    public static LoginResponse notLogin() {
        return new LoginResponse(false, null);
    }

    public static LoginResponse AlreadyLogin(User user) {
        return new LoginResponse(true, user);
    }

    public LoginResponse(){

    }
    public LoginResponse(boolean login, User user) {
        this.login = login;
        this.user = user;
    }

    public boolean isLogin() {
        return login;
    }

    public User getUser() {
        return user;
    }
}
