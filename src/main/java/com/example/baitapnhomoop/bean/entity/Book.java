package com.example.baitapnhomoop.bean.entity;

import com.example.baitapnhomoop.bean.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "book")
@Data
@Table(name = "book")
public class Book extends BaseEntity {

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "year_publish", nullable = false)
    private String yearPublish;

    @Column(name = "quantities", nullable = false)
    private Integer quantities;

    @Column(name = "version")
    private Integer version;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;

    public Book(String code, String name, String author, String provider, String yearPublish, Integer quantities, Integer version, String description, String image, Set<Category> categories) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.provider = provider;
        this.yearPublish = yearPublish;
        this.quantities = quantities;
        this.version = version;
        this.description = description;
        this.image = image;
        this.categories = categories;
    }

    public Book(Long id, LocalDateTime createdDate, String code, String name, String author, String provider, String yearPublish, Integer quantities, Integer version, String description, String image, Set<Category> categories) {
        super(id, createdDate);
        this.code = code;
        this.name = name;
        this.author = author;
        this.provider = provider;
        this.yearPublish = yearPublish;
        this.quantities = quantities;
        this.version = version;
        this.description = description;
        this.image = image;
        this.categories = categories;
    }

    public Book() {

    }
}
