package com.clone.instagram.service.impl;

import com.clone.instagram.dao.CommentDao;
import com.clone.instagram.dao.LikesDao;
import com.clone.instagram.dao.PostDao;
import com.clone.instagram.dao.UserDao;
import com.clone.instagram.exception.UserAlreadyLikePostsException;
import com.clone.instagram.exception.UserAlreadyUnlikePostsException;
import com.clone.instagram.model.Likes;
import com.clone.instagram.model.Post;
import com.clone.instagram.model.dto.PostAndCommentsDto;
import com.clone.instagram.model.dto.PostLikeUsersDto;
import com.clone.instagram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private LikesDao likesDao;

    @Autowired
    private UserDao userDao;

    @Override
    public int save(Post post){
        return postDao.insertPost(post);
    }

    @Override
    public int delete(int postId){
        return postDao.deletePost(postId);
    }

    @Override
    public Post getPosts(int postId){
        return postDao.selectPostById(postId);
    }

    @Override
    public PostAndCommentsDto getPostsAndComments(int postId){

        return PostAndCommentsDto.builder()
                .post(postDao.selectPostById(postId))
                .commentList(commentDao.selectCommentListByPostId(postId))
                .build();
    }


    @Override
    public PostLikeUsersDto getPostsLikeUsers(int postId){

        return PostLikeUsersDto.builder()
                .post(postDao.selectPostById(postId))
                .likeUserList(userDao.selectUserByPostId(postId))
                .build();
    }

    @Override
    @Transactional
    public int likePosts(int userId, int postId) throws UserAlreadyLikePostsException{

        try {
            likesDao.insertLikes(
                    Likes.builder()
                            .type(0)
                            .userId(userId)
                            .postId(postId)
                            .createDate(new Date())
                            .build()
            );
        } catch (DataIntegrityViolationException e) {
            throw new UserAlreadyLikePostsException(e);
        }
        return postDao.increaseNumberOfLikesByPostId(postId);

    }

    @Override
    @Transactional
    public int unlikePosts(int userId, int postId) throws UserAlreadyUnlikePostsException{

        Likes likes = likesDao.selectLikesByUserIdAndPostId(userId, postId)
                .orElseThrow(UserAlreadyUnlikePostsException::new);

        likesDao.deleteLikes(likes.getId());
        return postDao.decreaseNumberOfLikesByPostId(postId);
    }
}
