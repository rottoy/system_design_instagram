package com.clone.instagram.service;

import com.clone.instagram.model.Post;
import com.clone.instagram.model.payload.PagedResult;
import com.clone.instagram.model.payload.Paging;

import java.util.List;

public interface FeedService {

    PagedResult<Post> getNewsFeed(String username, Paging paging);
    void generateNewsFeed(String username);

}
