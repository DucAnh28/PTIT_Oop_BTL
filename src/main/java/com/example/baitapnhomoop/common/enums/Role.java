package com.example.baitapnhomoop.common.enums;

public enum Role {

    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN"),

    ;
    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
