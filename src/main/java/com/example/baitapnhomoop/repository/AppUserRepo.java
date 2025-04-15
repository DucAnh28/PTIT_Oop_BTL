package com.example.baitapnhomoop.repository;

import com.example.baitapnhomoop.bean.entity.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends CommonRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
