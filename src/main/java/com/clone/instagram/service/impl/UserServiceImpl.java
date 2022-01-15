package com.clone.instagram.service.impl;

import com.clone.instagram.model.User;
import com.clone.instagram.model.dto.UserDto;
import com.clone.instagram.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User save(){
        return null;
    }

    @Override
    public int follow(int userId1, int userId2){
        return 0;
    }

    @Override
    public int unfollow(int userId1, int userId2){
        return 0;
    }

    @Override
    public UserDto getUserAndPosts(int userId){
        return null;
    }
}
