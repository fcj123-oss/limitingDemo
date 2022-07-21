package com.limitingdemo.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author fcj
 * @date 2022/7/21 0021
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {



    //业务异常
    @ExceptionHandler(RedisLimitException.class)
    public String error(RedisLimitException e) {
        return e.getMessage();
    }


    //代码异常
    @ExceptionHandler(Exception.class)
    public String error(Exception e) {
        // TODO 业务处理
        return e.getMessage();
    }
}
