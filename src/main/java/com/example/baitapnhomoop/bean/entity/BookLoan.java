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

import java.time.LocalDateTime;

@Entity
@Table(name = "book_loan")
public class BookLoan extends BaseEntity {

    @JoinColumn(name = "book_id")
    @OneToOne
    private Book bookId;

    @JoinColumn(name = "user_id")
    @OneToOne
    private AppUser userId;

    @Column(name = "date_borrow", nullable = false)
    private LocalDateTime dateBorrow;

    @Column(name = "date_return", nullable = false)
    private LocalDateTime dateReturn;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @Column(name = "student_code", nullable = false)
    private String studentCode;

    public BookLoan(Book bookId, AppUser userId, LocalDateTime dateBorrow, LocalDateTime dateReturn, LoanStatus status, String studentCode) {
        this.bookId = bookId;
        this.userId = userId;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
        this.status = status;
        this.studentCode = studentCode;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public AppUser getUserId() {
        return userId;
    }

    public void setUserId(AppUser userId) {
        this.userId = userId;
    }

    public LocalDateTime getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(LocalDateTime dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public LocalDateTime getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDateTime dateReturn) {
        this.dateReturn = dateReturn;
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
}
