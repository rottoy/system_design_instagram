package com.clone.instagram.model;

import lombok.Data;

@Data
public class Comment {

    private int id;
    private int postId;
    private User user;
    private String content;
}
