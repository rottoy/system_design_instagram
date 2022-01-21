package com.clone.instagram.model.dto;

import lombok.Data;

@Data
public class FollowDto {

    private int fromUserId;
    private int toUserId;
}
