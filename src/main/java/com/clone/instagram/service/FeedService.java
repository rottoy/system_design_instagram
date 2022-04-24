package com.clone.instagram.service;

import com.clone.instagram.model.Post;

import com.clone.instagram.model.payload.SlicedResult;

import java.util.Optional;

public interface FeedService {

    SlicedResult<Post> getUserFeed(String username, Optional<String> pagingState);
    void generateUserFeed(Post post);

}
