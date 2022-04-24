package com.clone.instagram.model.dto;

import com.clone.instagram.model.Post;
import com.clone.instagram.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class PostLikeUsersDto {

    private Post post;
    private List<User> likeUserList;
}
