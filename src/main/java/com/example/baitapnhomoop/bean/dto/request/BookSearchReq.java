package com.example.baitapnhomoop.bean.dto.request;

import com.example.baitapnhomoop.bean.dto.PagingReq;

import java.util.List;

public class BookSearchReq extends PagingReq {

    private String key;
    private List<String> category;

    public BookSearchReq() {
    }

    public BookSearchReq(String key, List<String> category) {
        this.key = key;
        this.category = category;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }
}

