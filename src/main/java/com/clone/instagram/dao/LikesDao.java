package com.clone.instagram.dao;

import com.clone.instagram.model.Likes;
import com.clone.instagram.model.User;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;
import java.util.Optional;

public interface LikesDao {

    int insertLikes(Likes likes) throws DuplicateKeyException;
    int deleteLikes(int likesId) throws DuplicateKeyException;
    Optional<Likes> selectLikesByUserIdAndPostId(int userId, int postId);

}
