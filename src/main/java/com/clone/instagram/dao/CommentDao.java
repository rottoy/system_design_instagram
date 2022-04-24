package com.clone.instagram.dao;

import com.clone.instagram.model.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> selectCommentListByPostId(int postId);
}
