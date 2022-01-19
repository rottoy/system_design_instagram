package com.clone.instagram.model;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
public class User {

    private int id;
    private String userName;
    private String email;
    private String password;
    private Date dateOfBirth;
    private Date postUpdateDate;
    private Boolean isPublic;
    private int numberOfPost;
    private int numberOfFollower;
    private int numberOfFollowing;

    public User(){}
}
