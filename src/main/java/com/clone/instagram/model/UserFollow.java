package com.clone.instagram.model;

import lombok.Data;

@Data
public class UserFollow {

    private int id;
    private int followingId;
    private int followerId;
}
