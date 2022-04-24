package com.clone.instagram.service;

import com.clone.instagram.model.Post;
import com.clone.instagram.model.User;
import com.clone.instagram.model.dto.PostAndCommentsDto;
import com.clone.instagram.model.dto.PostLikeUsersDto;

import java.util.List;


public interface PostService {

    int save(Post post);
    int delete(int postId);
    Post getPosts(int postId);
    PostAndCommentsDto getPostsAndComments(int postId);
    PostLikeUsersDto getPostsLikeUsers(int postId);
    int likePosts(int userId, int postId);
    int unlikePosts(int userId, int postId);
}
