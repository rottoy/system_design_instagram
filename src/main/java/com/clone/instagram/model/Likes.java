package com.clone.instagram.model;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Likes {

    private int id;
    private int type;
    private int postId;
    private int userId;
    private Date createDate;
}
