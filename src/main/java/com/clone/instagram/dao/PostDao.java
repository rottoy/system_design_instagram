package com.clone.instagram.dao;

import com.clone.instagram.model.Post;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

public interface PostDao {

    List<Post> selectPostIn(List<Integer> postIds);
    int insertPost(Post post);
    int deletePost(int postId);
    Post selectPostById(int postId);
    int increaseNumberOfLikesByPostId(int postId);
    int decreaseNumberOfLikesByPostId(int postId);
}
