package com.example.baitapnhomoop.repository;

import com.example.baitapnhomoop.bean.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends CommonRepository<Book, Long> {

    Optional<Book> findByCode(String code);
}
