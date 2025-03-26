package com.example.baitapnhomoop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;

@Table(name = "app_role")
@Entity
public class AppRole extends BaseEntity implements GrantedAuthority {

    private String name;

    public AppRole(Long id, LocalDateTime createdDate, String name) {
        super(id, createdDate);
        this.name = name;
    }

    public AppRole(String name) {
        this.name = name;
    }

    public AppRole(LocalDateTime createdDate, Long id, String name) {
        super(createdDate, id);
        this.name = name;
    }

    public AppRole() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
