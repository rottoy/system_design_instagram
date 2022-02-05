package com.clone.instagram.service;

import com.clone.instagram.model.Post;
import com.clone.instagram.model.User;
import com.clone.instagram.model.dto.PostDto;

/*
* PostService
*
* */
public interface PostService {

    Post save(int userId);
    int delete(int postId);
    //List<Post> getTimeline(int userId); // hard
    PostDto getTimeline();
    Post getPosts(int postId);
    Post getPostsAndComments(int postId);
    //List<User> getPostsLikeUsers(int postId);
    User getPostsLikeUsers();
    int likePosts(int userId, int postId);
}
