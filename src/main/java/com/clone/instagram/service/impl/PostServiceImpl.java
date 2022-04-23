package com.clone.instagram.service.impl;

import com.clone.instagram.dao.PostDao;
import com.clone.instagram.model.Post;
import com.clone.instagram.model.User;
import com.clone.instagram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public int save(Post post){

        return postDao.insertPost(post);
    }

    @Override
    public int delete(int postId){
        return 0;
    }

    @Override
    public Post getPosts(int postId){
        return null;
    }

    @Override
    public Post getPostsAndComments(int postId){
        return null;
    }

    @Override
    public User getPostsLikeUsers(){
        return null;
    }

    @Override
    public int likePosts(int userId, int postId){
        return 0;
    }

    @Override
    public List<Post> getPostIn(List<Integer> postIds){
        return postDao.selectPostIn(postIds);
    }
}
