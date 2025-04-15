package com.example.baitapnhomoop.bean.entity;

import com.example.baitapnhomoop.bean.BaseEntity;
import com.example.baitapnhomoop.common.enums.LoanStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "book_loan")
public class BookLoan extends BaseEntity {

    @JoinColumn(name = "book_id")
    @OneToOne
    private Book book;

    @JoinColumn(name = "user_id")
    @OneToOne
    private AppUser userId;

    @Column(name = "date_borrow", nullable = false)
    private LocalDate dateBorrow;

    @Column(name = "date_return", nullable = false)
    private LocalDate dateReturn;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @Column(name = "student_code", nullable = false)
    private String studentCode;

    public BookLoan(Book book, AppUser userId, LocalDate dateBorrow, LocalDate dateReturn, LoanStatus status, String studentCode) {
        this.book = book;
        this.userId = userId;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
        this.status = status;
        this.studentCode = studentCode;
    }

    public BookLoan() {

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public AppUser getUserId() {
        return userId;
    }

    public void setUserId(AppUser userId) {
        this.userId = userId;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public LocalDate getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(LocalDate dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }
}

