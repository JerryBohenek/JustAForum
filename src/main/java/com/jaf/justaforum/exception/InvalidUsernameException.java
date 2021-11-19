package com.jaf.justaforum.exception;

public class InvalidUsernameException extends Exception{
    public InvalidUsernameException(String errorMessage) {
        super(errorMessage);
    }
}
