package com.example.baitapnhomoop.controller.admin;

import com.example.baitapnhomoop.bean.dto.BookDto;
import com.example.baitapnhomoop.bean.dto.CommonResp;
import com.example.baitapnhomoop.bean.dto.request.BookCreateReq;
import com.example.baitapnhomoop.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final LibraryService libraryService;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Admin Dashboard";
    }

    @PostMapping("/book/create")
    public BookDto createBook(@RequestBody BookCreateReq req) {
        return libraryService.createBook(req);
    }

    @GetMapping("/book-loan")
    public CommonResp<?> bookLoan() {
        return libraryService.bookLoanList();
    }

    @PutMapping("/book-loan/approve")
    public CommonResp<?> bookLoanApprove(@RequestParam Long id,
                                         @RequestParam String status) {
        return libraryService.approveBookLoan(id, status);
    }
}
