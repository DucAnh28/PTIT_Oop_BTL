package com.example.baitapnhomoop.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String id;

    private String error;

    private String message;

    private Object errorDetails;

    private JsonNode description;

    public ErrorResponse(String id, String error, String message) {
        this.id = id;
        this.error = error;
        this.message = message;
    }

    public ErrorResponse(String error, String message, Object errorDetails) {
        this.id = "error";
        this.error = error;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    public ErrorResponse(CommonException ex) {
        this.id = ex.getStatus().toString();
        this.error = ex.getError();
        this.message = ex.getMessage();
        this.errorDetails = ex.getErrorDetail();
    }

}