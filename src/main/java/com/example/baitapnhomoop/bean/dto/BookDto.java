package com.example.baitapnhomoop.bean.dto;

import com.example.baitapnhomoop.bean.entity.Book;
import com.example.baitapnhomoop.bean.entity.Category;
import org.springframework.beans.BeanUtils;

import java.util.Set;

public class BookDto {
    private String code;
    private String name;
    private String author;
    private String provider;
    private String yearPublish;
    private Integer quantities;
    private Integer version;
    private String description;
    private String image;
    private Set<Category> categories;

    public static BookDto convertAll(Book entity) {
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(entity, bookDto);
        return bookDto;
    }

    public BookDto() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
