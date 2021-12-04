package com.jaf.justaforum.exception;

public class InvalidPostCategoryException extends Exception{
    public InvalidPostCategoryException(String errorMessage) {
        super(errorMessage);
    }
}
