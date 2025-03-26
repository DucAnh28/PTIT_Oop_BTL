package com.example.baitapnhomoop.service;

import com.example.baitapnhomoop.entity.AppUser;
import com.example.baitapnhomoop.exception.CommonException;
import com.example.baitapnhomoop.repository.AppUserRepo;
import com.example.baitapnhomoop.request.LoginReq;
import com.example.baitapnhomoop.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtUtil jwtUtil;
    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AppUserRepo appUserRepo, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(LoginReq loginReq) {
        AppUser appUser = appUserRepo.findByUsername(loginReq.getUsername());
        if (appUser == null)
            throw new CommonException(HttpStatus.BAD_REQUEST, "User not found", "User not found", null);

        if (passwordEncoder.matches(loginReq.getPassword(), appUser.getPassword())) {
            return jwtUtil.generateToken(loginReq.getUsername());
        } else {
            throw new CommonException(HttpStatus.BAD_REQUEST, "Password incorrect", "password incorrect", null);
        }
    }
}
