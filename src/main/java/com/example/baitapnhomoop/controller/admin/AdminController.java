package com.example.baitapnhomoop.controller.admin;

import com.example.baitapnhomoop.bean.dto.BookDto;
import com.example.baitapnhomoop.bean.dto.CommonResp;
import com.example.baitapnhomoop.bean.dto.request.BookCreateReq;
import com.example.baitapnhomoop.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final LibraryService libraryService;

    public AdminController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/dashboard")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    public String dashboard() {
        return "Admin Dashboard";
    }

    @PostMapping("/book/create")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
    public BookDto createBook(@RequestBody BookCreateReq req) {
        return libraryService.createBook(req);
    }

    @GetMapping("/book-loan")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    public CommonResp<?> bookLoan() {
        return libraryService.bookLoanList();
    }

    @PutMapping("/book-loan/approve")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.PUT)
    public CommonResp<?> bookLoanApprove(@RequestParam Long id,
                                         @RequestParam String status) {
        return libraryService.approveBookLoan(id, status);
    }
}
