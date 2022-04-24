package com.clone.instagram.unit.service;

import com.clone.instagram.dao.LikesDao;
import com.clone.instagram.exception.UserAlreadyLikePostsException;
import com.clone.instagram.exception.UserAlreadyUnlikePostsException;
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
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    public void getPostLikeUsersTest(){
        int postId = 10000;
        assert postService.getPostsLikeUsers(postId).getLikeUserList().size() == 3;
    }

    @Test
    public void likePosts(){
        int postId = 10000;
        int userId = 1;
        postService.likePosts(userId, postId);
        assert postService.getPostsLikeUsers(postId).getLikeUserList().size() == 4;
        assert postService.getPosts(postId).getNumberOfLikes() == 4;

        try{
            postService.likePosts(userId, postId);
        }catch (Exception e){
            assert e.getClass() == UserAlreadyLikePostsException.class;
            return;
        }

        assert false;
    }

    @Test
    public void unlikePosts(){
        int postId = 10000;
        int userId = 2;
        postService.unlikePosts(userId, postId);
        assert postService.getPostsLikeUsers(postId).getLikeUserList().size() == 2;
        assert postService.getPosts(postId).getNumberOfLikes() == 2;
        try{
            postService.unlikePosts(userId, postId);
        }catch (Exception e){
            assert e.getClass() == UserAlreadyUnlikePostsException.class;
            return;
        }

        assert false;

    }
}
