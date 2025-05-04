package com.example.baitapnhomoop.service;

import com.example.baitapnhomoop.bean.dto.BookDto;
import com.example.baitapnhomoop.bean.dto.CommonResp;
import com.example.baitapnhomoop.bean.dto.PagingResp;
import com.example.baitapnhomoop.bean.dto.request.BookCreateReq;
import com.example.baitapnhomoop.bean.dto.request.BookLoanReq;
import com.example.baitapnhomoop.bean.dto.request.BookSearchReq;
import com.example.baitapnhomoop.bean.entity.AppUser;
import com.example.baitapnhomoop.bean.entity.Book;
import com.example.baitapnhomoop.bean.entity.BookLoan;
import com.example.baitapnhomoop.bean.entity.Category;
import com.example.baitapnhomoop.common.enums.LoanStatus;
import com.example.baitapnhomoop.exception.CommonException;
import com.example.baitapnhomoop.repository.BookLoanRepo;
import com.example.baitapnhomoop.repository.BookRepo;
import com.example.baitapnhomoop.repository.CategoryRepo;
import com.example.baitapnhomoop.repository.specification.BookSpecification;
import com.example.baitapnhomoop.util.SecurityUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final BookRepo bookRepository;

    private final CategoryRepo categoryRepository;

    private final BookLoanRepo bookLoanRepo;

    public static final String dateFormat = "yyyy-MM-dd";

    public LibraryService(BookRepo bookRepository, CategoryRepo categoryRepository, BookLoanRepo bookLoanRepo) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.bookLoanRepo = bookLoanRepo;
    }

    public PagingResp<BookDto> filter(BookSearchReq req) {
        PageRequest pageRequest = req.getPageable(req.getPageIndex(), req.getPageSize());

        Specification<Book> specification = BookSpecification.findByCode(req.getKey())
                .or(BookSpecification.findByName(req.getKey()))
                .or(BookSpecification.findByAuthor(req.getKey()))
                .or(BookSpecification.findByProvider(req.getKey()))
                .and(BookSpecification.findByCategory(req.getCategory()));

        Page<Book> books = bookRepository.findAll(specification, pageRequest);
        List<BookDto> dataResult;
        if (books.getContent().isEmpty()) {
            dataResult = new ArrayList<>();
        } else {
            dataResult = books.getContent().stream().map(BookDto::convertAll).toList();
        }
        return new PagingResp<>(books.getTotalElements(), req.getPageIndex(), req.getPageSize(), dataResult);
    }

    public BookDto createBook(BookCreateReq req) {
        List<Category> categories = categoryRepository.findAll();
        Set<Category> categorySet = categories.stream()
                .filter(category -> req.getCategories().contains(category.getCode()))
                .collect(Collectors.toSet());

        Book book = new Book();
        BeanUtils.copyProperties(req, book);
        book.setCategories(categorySet);
        book = bookRepository.save(book);

        return BookDto.convertAll(book);
    }

    public CommonResp<?> loan(BookLoanReq req) {
        AppUser currentUser = SecurityUtil.getCurrentUser();
        if (req.getBookCode() == null) return null;

        Book book = bookRepository.findByCode(req.getBookCode())
                .orElseThrow(() -> new CommonException(HttpStatus.BAD_REQUEST, "Book not found", "Book not found"));

        if (book.getQuantities() == 0)
            throw new CommonException(HttpStatus.BAD_REQUEST, "Book out of stock", "Book out of stock");

        BookLoan bookLoan = new BookLoan(
                book,
                currentUser,
                LocalDate.now(),
                LocalDate.parse(req.getDateReturn(), DateTimeFormatter.ofPattern(dateFormat)),
                LoanStatus.REQUEST,
                req.getStudentCode()
        );

        bookLoanRepo.save(bookLoan);

        return new CommonResp<>("Success", "Success");
    }

    public CommonResp<?> bookLoanList() {
        List<BookLoan> bookLoans = bookLoanRepo.findAllByStatusLike(LoanStatus.REQUEST);
        bookLoans.forEach(bookLoan -> {
            bookLoan.setUserBorrow(bookLoan.getUserId().getUsername());
            bookLoan.setUserId(null);
        });
        return new CommonResp<>("Success", "Success", bookLoans);
    }

    public CommonResp<?> approveBookLoan(Long id, String status) {
        BookLoan bookLoan = bookLoanRepo.findById(id)
                .orElseThrow(() -> new CommonException(HttpStatus.BAD_REQUEST, "Book loan not found", "Book loan not found"));

        if (LoanStatus.APPROVED.getValue().equalsIgnoreCase(status)) {
            bookLoan.getBook().setQuantities(bookLoan.getBook().getQuantities() - 1);
            bookLoan.setStatus(LoanStatus.APPROVED);
        } else if (LoanStatus.REJECTED.getValue().equalsIgnoreCase(status)) {
            bookLoan.setStatus(LoanStatus.REJECTED);
        }

        bookLoanRepo.save(bookLoan);
        return new CommonResp<>("Success", "Success");
    }

    public CommonResp<?> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return new CommonResp<>("Success", "Success", categories);
    }
}
