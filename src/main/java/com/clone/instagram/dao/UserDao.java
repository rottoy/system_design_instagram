package com.clone.instagram.dao;

import com.clone.instagram.model.User;

import java.util.List;

public interface UserDao {

    public List<User> selectFollowerList(int userId);
    public List<User> selectFollowingList(int userId);
}
