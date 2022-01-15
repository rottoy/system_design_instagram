package com.clone.instagram.model;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {

    private int id;
    private String userName;
    private String email;
    private String password;
    private Date dateOfBirth;
    private Date postUpdateDate;
    private Boolean isPublic;
    private int numberOfPosts;
    private int numberOfFollower;
    private int numberOfFollowing;


}
