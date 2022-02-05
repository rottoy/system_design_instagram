package com.clone.instagram.model.payload;


import lombok.Data;
import org.apache.ibatis.annotations.Param;
import sun.security.krb5.internal.PAData;

@Data
public class Paging {

    private int startPage;
    private int endPage;
    private int totalPage;
    private int curPage;


    public static Paging createPaging(int curPage, int totalSize, int pageSize){
        int totalPage = (int) Math.ceil((double) totalSize / (double) pageSize);
        int startPage = ((curPage - 1) / pageSize) * pageSize + 1;
        int endPage = curPage + pageSize - 1;

        if(curPage > totalPage){
            curPage = totalPage ;
        }

        Paging paging = new Paging();

        paging.setCurPage(curPage);
        paging.setEndPage(endPage);
        paging.setStartPage(startPage);
        paging.setTotalPage(totalPage);

        return paging;
    }
}
