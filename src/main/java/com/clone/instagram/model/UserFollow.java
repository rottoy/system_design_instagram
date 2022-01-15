package com.clone.instagram.model;

import lombok.Data;

@Data
public class UserFollow {

    private int id;
    private int followingUserId;
    private int followerUserId;
}
