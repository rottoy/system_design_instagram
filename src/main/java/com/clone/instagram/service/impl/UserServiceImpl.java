package com.clone.instagram.service.impl;

import com.clone.instagram.dao.PostDao;
import com.clone.instagram.dao.UserDao;
import com.clone.instagram.model.User;
import com.clone.instagram.model.dto.UserDto;
import com.clone.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public int save(User user){
        return userDao.insertUser(user);
    }

    @Override
    public int follow(int followerId, int followingId){
        return userDao.follow(followerId, followingId);
    }

    @Override
    public int unfollow(int followerId, int followingId){
        return userDao.unfollow(followerId, followingId);
    }

    @Override
    public List<User> getFollowingList(int userId){
        return userDao.selectFollowingList(userId);
    }

    @Override
    public List<User> getFollowerList(int userId){
        return userDao.selectFollowerList(userId);
    }


}
