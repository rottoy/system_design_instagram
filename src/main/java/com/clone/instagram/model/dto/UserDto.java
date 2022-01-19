package com.clone.instagram.model.dto;

import com.clone.instagram.model.User;
import com.clone.instagram.model.UserFollow;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends User {

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
    private List<UserFollow> userFollowList;
}
