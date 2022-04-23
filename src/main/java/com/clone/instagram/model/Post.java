package com.clone.instagram.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Post {

    private int id;
    private String title;
    private String userName;
    private int numberOfLikes;
    private Date updateDate;
    private Date createDate;
}
