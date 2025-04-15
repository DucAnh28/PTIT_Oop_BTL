package com.example.baitapnhomoop.bean.dto.request;

import java.util.Set;

public class BookCreateReq {

    private String name;
    private String code;
    private String author;
    private String provider;
    private String yearPublish;
    private Integer quantities;
    private String description;
    private String image;
    private Set<String> categories;

    public BookCreateReq() {
    }

    public BookCreateReq(String name, String code, String author, String provider, String yearPublish,
                         Integer quantities, String description, String image, Set<String> categories) {
        this.name = name;
        this.code = code;
        this.author = author;
        this.provider = provider;
        this.yearPublish = yearPublish;
        this.quantities = quantities;
        this.description = description;
        this.image = image;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(String yearPublish) {
        this.yearPublish = yearPublish;
    }

    public Integer getQuantities() {
        return quantities;
    }

    public void setQuantities(Integer quantities) {
        this.quantities = quantities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }
}
