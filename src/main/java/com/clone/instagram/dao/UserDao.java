package com.clone.instagram.dao;

import com.clone.instagram.model.User;

import java.util.List;

public interface UserDao {

    public List<User> selectUserList();
}
