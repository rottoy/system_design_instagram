package com.clone.instagram.service;

public interface LoginService {

    int login(int userId, int password);
    int logout(int userId);
};
