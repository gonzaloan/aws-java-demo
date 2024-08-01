package com.gonzaloan.realistic.domain.entities;

import java.util.List;

public class ApiResponse<T> {

    String message;
    List<T> details;

    public ApiResponse(String message, List<T> details) {
        this.message = message;
        this.details = details;
    }
    public String getMessage() {
        return message;
    }
    public List<T> getDetails() {
        return details;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setDetails(List<T> details) {
        this.details = details;
    }
}
