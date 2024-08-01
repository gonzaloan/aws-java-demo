package com.gonzaloan.realistic.infrastructure.exception;


import com.gonzaloan.realistic.domain.entities.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;

import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        ApiResponse<String> errorDetails = new ApiResponse<>("Error happened while validating fields", Collections.singletonList(ex.getMessage()));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex) {
        ApiResponse<String> errorDetails = new ApiResponse<>("Error happened", Collections.singletonList(ex.getMessage()));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchKeyException.class)
    public ResponseEntity<ApiResponse<String>> handleNoSuchKeyException(NoSuchKeyException ex) {
        ApiResponse<String> errorDetails = new ApiResponse<>("Error happened while retrieving information from S3", Collections.singletonList(ex.getMessage()));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
