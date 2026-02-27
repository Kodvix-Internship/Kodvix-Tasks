package com.example.studenttask.exception;

public class UnauthorizedException
        extends RuntimeException {

    public UnauthorizedException(String message) {
        super(message);
    }
}