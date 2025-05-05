package com.example.baitapnhomoop.repository;

import com.example.baitapnhomoop.bean.entity.AppRole;
import com.example.baitapnhomoop.common.enums.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepo extends CommonRepository<AppRole, Long> {

    AppRole findAppRolesByName(Role roleName);
}
