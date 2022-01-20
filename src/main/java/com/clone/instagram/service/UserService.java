package com.clone.instagram.service;

import com.clone.instagram.model.User;
import com.clone.instagram.model.dto.UserDto;

import java.util.List;

public interface UserService {

    int save(User user);
    int follow(int userId1, int userId2);
    int unfollow(int userId1, int userId2);
    List<User> getFollowingList(int userId);
    List<User> getFollowerList(int userId);
    //User getUserAndPosts(int userId);
}
