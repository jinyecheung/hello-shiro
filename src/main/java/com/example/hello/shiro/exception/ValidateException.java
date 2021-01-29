package com.example.hello.shiro.exception;

public class ValidateException extends RuntimeException {
    private static final long serialVersionUID = -20210129135948L;

    public ValidateException() {
    }

    public ValidateException(String msg) {
        super(msg);
    }
}
