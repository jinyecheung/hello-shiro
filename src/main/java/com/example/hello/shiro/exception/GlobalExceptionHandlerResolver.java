package com.example.hello.shiro.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author now ak
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerResolver {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultClass<String> handleGlobalException(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return ResultClass.failed(e.getLocalizedMessage());
    }

    @ExceptionHandler(ValidateException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultClass<String> handleValidateException(ValidateException e) {
        log.error("参数校验异常 ex={}", e.getMessage(), e);
        return ResultClass.failed(e.getLocalizedMessage());
    }

    @ExceptionHandler(BusiException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultClass<String> handleBusiException(BusiException e) {
        log.error("业务处理异常 ex={}", e.getMessage(), e);
        return ResultClass.failed(e.getLocalizedMessage());
    }

//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public Result<String> handleAccessDeniedException(AccessDeniedException e) {
//        String msg = SpringSecurityMessageSource.getAccessor()
//                .getMessage("AbstractAccessDecisionManager.accessDenied"
//                        , e.getMessage());
//        log.error("拒绝授权异常信息 ex={}", msg, e);
//        return ResultClass.failed(e.getLocalizedMessage());
//    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultClass<String> handleBodyValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        log.warn("参数绑定异常,ex = {}", fieldErrors.get(0).getDefaultMessage());
        return ResultClass.failed(fieldErrors.get(0).getDefaultMessage());
    }


    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultClass<String> bindExceptionHandler(BindException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        log.warn("参数绑定异常,ex = {}", fieldErrors.get(0).getDefaultMessage());
        return ResultClass.failed(fieldErrors.get(0).getDefaultMessage());
    }
}

