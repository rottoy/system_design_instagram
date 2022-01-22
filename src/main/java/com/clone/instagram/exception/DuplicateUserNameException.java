package com.clone.instagram.exception;

public class DuplicateUserNameException extends RuntimeException{

    public DuplicateUserNameException(Throwable cause){
        super(cause);
    }
}
