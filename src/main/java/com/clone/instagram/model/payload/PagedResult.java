package com.clone.instagram.model.payload;

import lombok.Data;

import java.util.List;

@Data
public class PagedResult<T> {

    int curPage;
    int totalPage;
    int startPage;
    int endPage;
    List<T> contents;

}
