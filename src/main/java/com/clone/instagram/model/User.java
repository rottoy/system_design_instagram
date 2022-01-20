package com.clone.instagram.model;


import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

}
