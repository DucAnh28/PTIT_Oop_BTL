package com.example.baitapnhomoop.bean.dto.request;

import com.example.baitapnhomoop.bean.dto.PagingReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookSearchReq extends PagingReq {

    private String name;
    private String author;
    private String provider;
    private String code;
    private List<String> category;

    public BookSearchReq() {
    }

    public BookSearchReq(String name, String author, String provider, String code) {
        this.name = name;
        this.author = author;
        this.provider = provider;
        this.code = code;
    }

    public BookSearchReq(String name, String author, String provider, String code, List<String> category) {
        this.name = name;
        this.author = author;
        this.provider = provider;
        this.code = code;
        this.category = category;
    }
}

