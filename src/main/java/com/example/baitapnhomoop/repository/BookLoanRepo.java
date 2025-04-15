package com.example.baitapnhomoop.repository;

import com.example.baitapnhomoop.bean.entity.BookLoan;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoanRepo extends CommonRepository<BookLoan, Long> {
}
