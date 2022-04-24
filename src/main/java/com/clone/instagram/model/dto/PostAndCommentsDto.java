package com.clone.instagram.model.dto;

import com.clone.instagram.model.Comment;
import com.clone.instagram.model.Post;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class PostAndCommentsDto {


    private Post post;
    private List<Comment> commentList;
}
