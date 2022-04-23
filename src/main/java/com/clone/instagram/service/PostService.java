package com.clone.instagram.service;

import com.clone.instagram.model.Post;
import com.clone.instagram.model.User;
import com.clone.instagram.model.dto.PostDto;

import java.util.List;

/*
* PostService
*
* */
public interface PostService {

    int save(Post post);
    int delete(int postId);
    Post getPosts(int postId);
    Post getPostsAndComments(int postId);
    //List<User> getPostsLikeUsers(int postId);
    User getPostsLikeUsers();
    int likePosts(int userId, int postId);
    List<Post> getPostIn(List<Integer> postIds);
}
