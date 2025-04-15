package com.example.baitapnhomoop.repository;

import com.example.baitapnhomoop.bean.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CommonRepository<Category, Long> {
}
