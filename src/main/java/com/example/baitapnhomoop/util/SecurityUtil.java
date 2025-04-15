package com.example.baitapnhomoop.util;

import com.example.baitapnhomoop.bean.entity.AppUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static AppUser getCurrentUser() {
        return (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
