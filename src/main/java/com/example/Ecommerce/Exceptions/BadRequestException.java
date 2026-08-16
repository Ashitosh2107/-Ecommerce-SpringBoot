package com.example.Ecommerce.Exceptions;


public class BadRequestException extends org.apache.coyote.BadRequestException {
    public BadRequestException(String message) {
        super(message);
    }
}