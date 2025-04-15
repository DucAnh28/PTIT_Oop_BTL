package com.example.baitapnhomoop.repository;

import com.example.baitapnhomoop.bean.entity.BookLoan;
import com.example.baitapnhomoop.common.enums.LoanStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLoanRepo extends CommonRepository<BookLoan, Long> {

    List<BookLoan> findAllByStatusLike(LoanStatus status);
}
