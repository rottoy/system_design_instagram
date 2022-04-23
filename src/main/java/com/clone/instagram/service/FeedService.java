package com.clone.instagram.service;

import com.clone.instagram.model.Post;

import com.clone.instagram.payload.SlicedResult;
import com.datastax.oss.driver.api.core.cql.PagingState;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.Optional;

public interface FeedService {

    SlicedResult<Post> getUserFeed(String username, Optional<String> pagingState);
    void generateUserFeed(Post post);

}
