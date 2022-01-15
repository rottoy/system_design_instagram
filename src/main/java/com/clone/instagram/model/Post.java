package com.clone.instagram.model;

import lombok.Data;

import java.util.Date;

@Data
public class Post {

    private int id;
    private String title;
    private int numberOfLikes;
    private Date updateDate;
    private Date createDate;
}
