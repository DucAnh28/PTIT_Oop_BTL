package com.example.baitapnhomoop.controller;

import com.example.baitapnhomoop.bean.dto.BookDto;
import com.example.baitapnhomoop.bean.dto.CommonResp;
import com.example.baitapnhomoop.bean.dto.PagingResp;
import com.example.baitapnhomoop.bean.dto.request.BookLoanReq;
import com.example.baitapnhomoop.bean.dto.request.BookSearchReq;
import com.example.baitapnhomoop.service.LibraryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/filter")
    public PagingResp<BookDto> filter(BookSearchReq req) {
        return libraryService.filter(req);
    }

    @PostMapping("/loan")
    public CommonResp<?> loan(@RequestBody BookLoanReq req) {
        return libraryService.loan(req);
    }

    @GetMapping("/categories")
    public CommonResp<?> categories() {
        return libraryService.findAllCategories();
    }
}
