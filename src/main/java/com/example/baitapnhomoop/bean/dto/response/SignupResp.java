package com.example.baitapnhomoop.bean.dto.response;

import com.example.baitapnhomoop.bean.entity.AppRole;

import java.util.Set;

public class SignupResp {
    String status;
    String username;
    String email;
    String phone;
    Set<AppRole> roles;

    public SignupResp() {
    }

    public SignupResp(String status, String username, String email, String phone, Set<AppRole> roles) {
        this.status = status;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }
}
