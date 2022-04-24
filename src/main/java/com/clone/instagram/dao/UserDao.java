package com.clone.instagram.dao;

import com.clone.instagram.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface UserDao {

    public int insertUser(User user) throws DuplicateKeyException;
    public int unfollow(int followerId, int followingId) throws DuplicateKeyException;
    public int follow(int followerId, int followingId) throws DuplicateKeyException;
    public List<User> selectFollowerList(int userId, Pageable pageable);
    public List<User> selectFollowingList(int userId, Pageable pageable);
    List<User> selectUserByPostId(int postId);
    User selectUserByUserName(String userName);
}
