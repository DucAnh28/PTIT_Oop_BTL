package com.example.baitapnhomoop.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<?> handleCommonException(CommonException commonException) {
        return ResponseEntity.status(commonException.getStatus()).body(new ErrorResponse(commonException));
    }

}
