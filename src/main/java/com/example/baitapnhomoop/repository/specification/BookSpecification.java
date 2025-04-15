package com.example.baitapnhomoop.repository.specification;

import com.example.baitapnhomoop.bean.entity.Book;
import com.example.baitapnhomoop.bean.entity.Category;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class BookSpecification {

    public BookSpecification() {
    }

    public static Specification<Book> findByName(String name) {
        return (root, query, cb) -> name == null ? cb.and() : cb.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Book> findByCode(String code) {
        return (root, query, cb) -> code == null ? cb.and() : cb.like(root.get("code"), "%" + code + "%");
    }

    public static Specification<Book> findByAuthor(String author) {
        return (root, query, cb) -> author == null ? cb.and() : cb.like(root.get("author"), "%" + author + "%");
    }

    public static Specification<Book> findByProvider(String provider) {
        return (root, query, cb) -> provider == null ? cb.and() : cb.like(root.get("provider"), "%" + provider + "%");
    }

    public static Specification<Book> findByCategory(List<String> category) {
        return (root, query, cb) -> {
            Join<Book, Category> categoryJoin = root.join("categories");
            return category == null ? cb.and() : categoryJoin.get("code").in(category);
        };
    }
}