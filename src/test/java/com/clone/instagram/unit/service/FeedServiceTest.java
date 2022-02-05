package com.clone.instagram.unit.service;


import com.clone.instagram.model.Post;
import com.clone.instagram.model.payload.PagedResult;
import com.clone.instagram.model.payload.Paging;
import com.clone.instagram.service.FeedService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class FeedServiceTest {

    @Autowired
    private FeedService feedService;

    @Test
    void getNewsFeed(){
        PagedResult<Post> newsfeed = feedService.getNewsFeed("rottoy", Paging.createPaging(1,30,10));
    }
}
