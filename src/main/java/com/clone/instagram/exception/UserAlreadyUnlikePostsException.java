package com.clone.instagram.exception;

public class UserAlreadyUnlikePostsException extends RuntimeException{

    public UserAlreadyUnlikePostsException(Throwable cause){
        super(cause);
    }

    public UserAlreadyUnlikePostsException(){
        super();
    }
}
