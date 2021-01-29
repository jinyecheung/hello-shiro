package com.example.hello.shiro.exception;

import java.io.Serializable;

public class ResultClass<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private T data;

    public static <T> ResultClass<T> ok() {
        return (ResultClass<T>) restResult((Object)null, ReturnCode.SUCCESS.getCode(), (String)null);
    }

    public static <T> ResultClass<T> ok(T data) {
        return restResult(data, ReturnCode.SUCCESS.getCode(), (String)null);
    }

    public static <T> ResultClass<T> ok(T data, String msg) {
        return restResult(data, ReturnCode.SUCCESS.getCode(), msg);
    }

    public static <T> ResultClass<T> failed() {
        return (ResultClass<T>) restResult((Object)null, ReturnCode.FAIL.getCode(), (String)null);
    }

    public static <T> ResultClass<T> failed(String msg) {
        return (ResultClass<T>) restResult((Object)null, ReturnCode.FAIL.getCode(), msg);
    }

    public static <T> ResultClass<T> failed(T data) {
        return restResult(data, ReturnCode.FAIL.getCode(), (String)null);
    }

    private static <T> ResultClass<T> restResult(T data, String code, String msg) {
        ResultClass<T> apiResult = new ResultClass();
        apiResult.setCode(code).setData(data).setMessage(msg);
        return apiResult;
    }

    public static <T> ResultClass.ResultBuilder<T> builder() {
        return new ResultClass.ResultBuilder();
    }

    @Override
    public String toString() {
        return "Result(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }

    public ResultClass() {
    }

    public ResultClass(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public ResultClass<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ResultClass<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public ResultClass<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static class ResultBuilder<T> {
        private String code;
        private String message;
        private T data;

        ResultBuilder() {
        }

        public ResultClass.ResultBuilder<T> code(String code) {
            this.code = code;
            return this;
        }

        public ResultClass.ResultBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public ResultClass.ResultBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResultClass<T> build() {
            return new ResultClass(this.code, this.message, this.data);
        }

        @Override
        public String toString() {
            return "Result.ResultBuilder(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ")";
        }
    }
}
