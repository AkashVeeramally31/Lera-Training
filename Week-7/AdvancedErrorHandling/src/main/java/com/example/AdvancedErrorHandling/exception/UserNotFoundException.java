package com.example.AdvancedErrorHandling.exception;

// This class defines a custom exception when a user is not found.

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }
}
