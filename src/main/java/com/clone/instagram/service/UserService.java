package com.clone.instagram.service;

import com.clone.instagram.model.User;
import com.clone.instagram.model.dto.UserDto;

public interface UserService {

    User save();
    int follow(int userId1, int userId2);
    int unfollow(int userId1, int userId2);
    UserDto getUserAndPosts(int userId);
    //User getUserAndPosts(int userId);
}
