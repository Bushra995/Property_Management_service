package com.Property_Management_service.exception;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class ErrorResponse {

    private String message;
    private int statusCode;

    public ErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    // Getter methods
    // ...
}