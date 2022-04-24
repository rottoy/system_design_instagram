package com.clone.instagram.service.impl;

import com.clone.instagram.dao.UserDao;
import com.clone.instagram.exception.DuplicateUserNameException;
import com.clone.instagram.exception.UserAlreadyFollowException;
import com.clone.instagram.model.User;
import com.clone.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public int save(User user) throws DuplicateUserNameException{
        try {
            return userDao.insertUser(user);
        }catch (DataIntegrityViolationException e){
            throw new DuplicateUserNameException(e);
        }
    }

    @Override
    @Transactional
    public int follow(int followerId, int followingId) throws UserAlreadyFollowException{
        try{
            return userDao.follow(followerId, followingId);
        }catch (DataIntegrityViolationException e) {
            throw new UserAlreadyFollowException(e);
        }
    }

    @Override
    @Transactional
    public int unfollow(int followerId, int followingId) throws UserAlreadyFollowException{
        try{
            return userDao.unfollow(followerId, followingId);
        }catch (DataIntegrityViolationException e) {
            throw new UserAlreadyFollowException(e);
        }
    }

    @Override
    public List<User> getFollowingList(int userId, Pageable page){
        return userDao.selectFollowingList(userId, page);
    }

    @Override
    public List<User> getFollowerList(int userId, Pageable page){
        return userDao.selectFollowerList(userId, page);
    }

    @Override
    public User getUser(String userName){
        return userDao.selectUserByUserName(userName);
    }
}
