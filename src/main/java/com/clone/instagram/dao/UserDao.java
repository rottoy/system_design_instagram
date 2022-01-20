package com.clone.instagram.dao;

import com.clone.instagram.model.User;
import com.clone.instagram.model.UserFollow;
import com.clone.instagram.model.dto.UserDto;

import java.util.List;

public interface UserDao {

    public int insertUser(User user);
    public int unfollow(int followerId, int followingId);
    public int follow(int followerId, int followingId);
    public List<User> selectFollowerList(int userId);
    public List<User> selectFollowingList(int userId);
}
