package com.clone.instagram.dao;

import com.clone.instagram.model.User;
import com.clone.instagram.model.UserFollow;
import com.clone.instagram.model.dto.UserDto;

import java.util.List;

public interface UserDao {

    public List<User> selectFollowerList(int userId);
    public List<UserDto> selectFollowingList(int userId);
}
