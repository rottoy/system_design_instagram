package com.clone.instagram.dao;

import com.clone.instagram.model.Post;

import java.util.List;

public interface PostDao {

    List<Post> selectPostIn(List<Integer> postIds);
    int insertPost(Post post);
}
