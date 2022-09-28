package com.example.sampleunittest.exception;

/**
 * @author absatyap
 **/
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with id " + id + " not found!");
    }
}
