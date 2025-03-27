package com.example.baitapnhomoop.service;

import com.example.baitapnhomoop.common.enums.Role;
import com.example.baitapnhomoop.entity.AppRole;
import com.example.baitapnhomoop.entity.AppUser;
import com.example.baitapnhomoop.exception.CommonException;
import com.example.baitapnhomoop.repository.AppRoleRepo;
import com.example.baitapnhomoop.repository.AppUserRepo;
import com.example.baitapnhomoop.request.SigninReq;
import com.example.baitapnhomoop.request.SignupReq;
import com.example.baitapnhomoop.response.SigninResp;
import com.example.baitapnhomoop.response.SignupResp;
import com.example.baitapnhomoop.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final JwtUtil jwtUtil;
    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;
    private final AppRoleRepo appRoleRepo;

    public AuthService(AppUserRepo appUserRepo, JwtUtil jwtUtil, PasswordEncoder passwordEncoder, AppRoleRepo appRoleRepo) {
        this.appUserRepo = appUserRepo;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.appRoleRepo = appRoleRepo;
    }

    public SigninResp login(SigninReq signinReq) {
        AppUser appUser = appUserRepo.findByUsername(signinReq.getUsername());
        if (appUser == null)
            throw new CommonException(HttpStatus.BAD_REQUEST, "User not found", "User not found", null);

        if (passwordEncoder.matches(signinReq.getPassword(), appUser.getPassword())) {
            String token = jwtUtil.generateToken(signinReq.getUsername());
            return new SigninResp(token);
        } else {
            throw new CommonException(HttpStatus.BAD_REQUEST, "Password incorrect", "password incorrect", null);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public SignupResp register(SignupReq signupReq) {
        Set<AppRole> appRoles = appRoleRepo.findAll().stream()
                .filter(appRole -> appRole.getName().equals(Role.ROLE_USER))
                .collect(Collectors.toSet());

        AppUser appUser = new AppUser();
        appUser.setUsername(signupReq.getUsername());
        appUser.setEmail(signupReq.getEmail());
        appUser.setPassword(passwordEncoder.encode(signupReq.getPassword()));
        appUser.setPhone(signupReq.getPhone());
        appUser.setRoles(appRoles);

        appUserRepo.save(appUser);
        return new SignupResp();
    }
}
