package com.example.baitapnhomoop.entity;

import com.example.baitapnhomoop.common.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Table(name = "app_role")
@Entity
public class AppRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role name;

    public AppRole(Role name) {
        this.name = name;
    }

    public AppRole(Long id, Role name) {
        this.id = id;
        this.name = name;
    }

    public AppRole() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name.getValue();
    }
}
