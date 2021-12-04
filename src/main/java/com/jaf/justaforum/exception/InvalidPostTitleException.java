package com.jaf.justaforum.exception;

public class InvalidPostTitleException extends Exception{
    public InvalidPostTitleException(String errorMessage) {
        super(errorMessage);
    }
}
