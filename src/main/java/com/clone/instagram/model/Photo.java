package com.clone.instagram.model;


import lombok.Data;

import java.util.Date;

@Data
public class Photo {

    private int id;
    private int postId;
    private int userId;
    private String photoPath;
    private int photoLatitude;
    private int photoLongtitude;
    private Date createDate;

}
