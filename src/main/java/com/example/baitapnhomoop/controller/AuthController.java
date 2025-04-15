package com.example.baitapnhomoop.controller;

import com.example.baitapnhomoop.bean.dto.request.SigninReq;
import com.example.baitapnhomoop.bean.dto.request.SignupReq;
import com.example.baitapnhomoop.bean.dto.response.SigninResp;
import com.example.baitapnhomoop.bean.dto.response.SignupResp;
import com.example.baitapnhomoop.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public SigninResp login(@RequestBody SigninReq signinReq) {
        return authService.login(signinReq);
    }

    @PostMapping("/signup")
    public SignupResp register(@RequestBody @Valid SignupReq signupReq) {
        return authService.register(signupReq);
    }
}
