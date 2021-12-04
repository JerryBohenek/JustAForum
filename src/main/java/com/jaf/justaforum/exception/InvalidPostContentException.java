package com.jaf.justaforum.exception;

public class InvalidPostContentException extends Exception{
    public InvalidPostContentException(String errorMessage) {
        super(errorMessage);
    }
}
