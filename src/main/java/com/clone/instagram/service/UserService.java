package com.clone.instagram.service;

import com.clone.instagram.exception.UserAlreadyFollowException;
import com.clone.instagram.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface UserService {

    int save(User user);
    int follow(int userId1, int userId2) throws UserAlreadyFollowException;
    int unfollow(int userId1, int userId2)throws UserAlreadyFollowException;
    List<User> getFollowingList(int userId, Pageable page);
    List<User> getFollowerList(int userId, Pageable page);

    User getUser(String userName);
}
