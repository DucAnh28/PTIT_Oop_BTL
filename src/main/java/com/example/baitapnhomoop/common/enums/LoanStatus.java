package com.example.baitapnhomoop.common.enums;

import lombok.Getter;

@Getter
public enum LoanStatus {
    REQUEST("REQUEST"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED");
    private final String value;

    LoanStatus(String value) {
        this.value = value;
    }

}
