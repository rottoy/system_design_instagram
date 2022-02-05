package com.clone.instagram.dao;

import com.clone.instagram.model.User;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

public interface UserDao {

    public int insertUser(User user) throws DuplicateKeyException;
    public int unfollow(int followerId, int followingId) throws DuplicateKeyException;
    public int follow(int followerId, int followingId) throws DuplicateKeyException;
    public List<User> selectFollowerList(int userId);
    public List<User> selectFollowingList(int userId);
    User selectUserByUserName(String userName);
}
