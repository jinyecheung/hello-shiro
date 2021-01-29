package com.example.hello.shiro.exception;


public class BusiException extends RuntimeException {

    private static final long serialVersionUID = -1;

    public BusiException() {
    }

    public BusiException(String msg) {
        super(msg);
    }

    public BusiException(String msg, Exception e) {
        super(msg, e);
    }
}
