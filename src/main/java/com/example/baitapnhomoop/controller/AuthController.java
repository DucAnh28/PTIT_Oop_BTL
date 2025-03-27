package com.example.baitapnhomoop.controller;

import com.example.baitapnhomoop.request.SigninReq;
import com.example.baitapnhomoop.request.SignupReq;
import com.example.baitapnhomoop.response.SigninResp;
import com.example.baitapnhomoop.response.SignupResp;
import com.example.baitapnhomoop.service.AuthService;
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
    public SignupResp register(@RequestBody SignupReq signupReq) {
        return authService.register(signupReq);
    }
}
