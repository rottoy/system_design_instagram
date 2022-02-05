package com.clone.instagram.service;

import com.clone.instagram.exception.UserAlreadyFollowException;
import com.clone.instagram.model.User;

import java.util.List;

public interface UserService {

    int save(User user);
    int follow(int userId1, int userId2) throws UserAlreadyFollowException;
    int unfollow(int userId1, int userId2)throws UserAlreadyFollowException ;
    List<User> getFollowingList(int userId);
    List<User> getFollowerList(int userId);
    User getUser(String userName);
    //User getUserAndPosts(int userId);
}
