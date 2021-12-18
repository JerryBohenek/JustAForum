package com.jaf.justaforum.exception;

public class InvalidCommentContentException extends Exception{
    public InvalidCommentContentException(String errorMessage) {
        super(errorMessage);
    }
}
