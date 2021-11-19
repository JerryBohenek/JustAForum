package com.jaf.justaforum.exception;

public class InvalidPasswordException  extends Exception{
    public InvalidPasswordException(String errorMessage) {
        super(errorMessage);
    }
}
