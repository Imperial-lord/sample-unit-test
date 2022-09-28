package com.example.sampleunittest.exception;

/**
 * @author absatyap
 **/
public class InvalidUserException extends RuntimeException {
    public InvalidUserException() {
        super("Either the user or one or more of its fields are invalid");
    }
}
