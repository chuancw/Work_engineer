package com.chuancw.work.service;

import com.chuancw.work.model.sql_class.User;

public interface UserService {

    public User login(String username, String password);
}
