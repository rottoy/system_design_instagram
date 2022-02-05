package com.clone.instagram.service.impl;

import com.clone.instagram.model.Post;
import com.clone.instagram.model.User;
import com.clone.instagram.model.payload.PagedResult;
import com.clone.instagram.model.payload.Paging;
import com.clone.instagram.service.FeedService;
import com.clone.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    UserService userService;

    @Override
    public PagedResult<Post> getNewsFeed(String username, Paging paging){
        return null;
    }

    @Override
    public void generateNewsFeed(String username){

        //todo : userList need pageable
        List<User> userList = userService.getFollowingList(
                userService.getUser(username).getId());

        //todo : push post to the feeds for those IDs. requires push-model.
    }
}
