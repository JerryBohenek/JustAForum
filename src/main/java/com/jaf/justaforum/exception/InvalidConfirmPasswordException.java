package com.jaf.justaforum.exception;

public class InvalidConfirmPasswordException extends Exception{
    public InvalidConfirmPasswordException(String errorMessage) {
        super(errorMessage);
    }
}
