package com.clone.instagram.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FollowDto {

    private int fromUserId;
    private int toUserId;

}
