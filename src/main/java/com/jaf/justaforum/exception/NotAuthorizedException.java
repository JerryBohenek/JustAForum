package com.jaf.justaforum.exception;

public class NotAuthorizedException extends Exception{
    public NotAuthorizedException(String errorMessage) {
        super(errorMessage);
    }
}
