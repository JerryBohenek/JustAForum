package com.jaf.justaforum.exception;

public class InvalidEmailException extends Exception{
    public InvalidEmailException(String errorMessage) {
        super(errorMessage);
    }
}
