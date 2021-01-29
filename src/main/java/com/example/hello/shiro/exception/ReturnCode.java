package com.example.hello.shiro.exception;


import org.springframework.http.HttpStatus;

public enum ReturnCode {
    SUCCESS(HttpStatus.OK, "0", "操作成功"),
    UNAUTHORIZED(HttpStatus.BAD_REQUEST, "401", "非法访问.%s"),
    NOT_PERMISSION(HttpStatus.BAD_REQUEST, "403", "没有权限.%s"),
    NOT_FOUND(HttpStatus.BAD_REQUEST, "404", "你请求的资源不存在.%s"),
    FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "500", "操作失败.");

    private HttpStatus httpStatus;
    private final String code;
    private final String msg;

    private ReturnCode(HttpStatus httpStatus, String code, String msg) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}

