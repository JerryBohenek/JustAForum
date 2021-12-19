package com.jaf.justaforum.exception;

public class CommentNotFoundException extends Exception{
    public CommentNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
