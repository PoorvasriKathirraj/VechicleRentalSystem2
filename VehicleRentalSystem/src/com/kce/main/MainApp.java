package com.kce.main;

import com.kce.model.UserService;

public class MainApp {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.start();
    }
}