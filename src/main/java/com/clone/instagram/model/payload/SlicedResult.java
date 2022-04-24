package com.clone.instagram.model.payload;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SlicedResult<T> {

    private String pageState;
    private boolean isLast;
    private List<T> content;

}
