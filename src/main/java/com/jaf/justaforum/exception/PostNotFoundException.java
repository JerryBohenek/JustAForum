package com.jaf.justaforum.exception;

public class PostNotFoundException extends Exception{
    public PostNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
