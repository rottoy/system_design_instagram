package com.clone.instagram.unit.service;

import com.clone.instagram.model.Post;
import com.clone.instagram.service.FeedService;
import com.clone.instagram.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class FeedServiceTest {

    @Autowired
    private FeedService feedService;

    @Autowired
    private PostService postService;

    @Test
    public void getUserFeed(){

        System.out.println(feedService.getUserFeed("garen", java.util.Optional.empty()));

    }

    @Test
    public void generateUserFeed(){
        //System.out.println(userDao.selectUserByUserName("garen"));
        System.out.println("before :" + feedService.getUserFeed("1q2w3e4r", java.util.Optional.empty()));

        //1. generate user feed
        Post post = Post.builder()
                .id(10017)
                .title("generateUserFeed written by garen")
                .userName("garen")
                .build();

        //2. check if follower's feed contains follower's post
        if (postService.save(post) != 0) {
            feedService.generateUserFeed(post);
        }

        System.out.println("after :" + feedService.getUserFeed("1q2w3e4r", java.util.Optional.empty()));
    }
}
