package com.example.DataValidation.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}

//We need to give this message to user by creating another @ExceptionHandler in ApplicationExceptionHandler
