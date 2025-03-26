package com.example.baitapnhomoop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Set;

@Table(name = "app_user")
@Entity
public class AppUser extends BaseEntity {

    @Column(columnDefinition = "varchar(255)", unique = true)
    private String email;

    @Column(columnDefinition = "varchar(255)", unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column()
    private String phone;

    @Column(columnDefinition = "int default 1")
    private int status;

    @Column
    private String address;

    @Column()
    private String ava;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> appRoles;

    public AppUser(Long id, LocalDateTime createdDate, String email, String username, String password, String phone, int status, String address, String ava, Set<AppRole> appRoles) {
        super(id, createdDate);
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.address = address;
        this.ava = ava;
        this.appRoles = appRoles;
    }

    public AppUser(String email, String username, String password, String phone, int status, String address, String ava, Set<AppRole> appRoles) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.address = address;
        this.ava = ava;
        this.appRoles = appRoles;
    }

    public AppUser(LocalDateTime createdDate, Long id, String email, String username, String password, String phone, int status, String address, String ava, Set<AppRole> appRoles) {
        super(createdDate, id);
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.address = address;
        this.ava = ava;
        this.appRoles = appRoles;
    }

    public AppUser() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAva() {
        return ava;
    }

    public void setAva(String ava) {
        this.ava = ava;
    }

    public Set<AppRole> getRoles() {
        return appRoles;
    }

    public void setRoles(Set<AppRole> appRoles) {
        this.appRoles = appRoles;
    }
}
