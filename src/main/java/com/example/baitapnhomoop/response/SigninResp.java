package com.example.baitapnhomoop.response;

public class SigninResp {

    private String accessToken;

    public SigninResp(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
