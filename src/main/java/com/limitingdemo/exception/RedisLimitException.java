package com.limitingdemo.exception;

/**
 * @author fcj
 * @date 2022/7/21 0021
 */
public class RedisLimitException extends RuntimeException{
    public RedisLimitException(String msg) {
        super( msg );
    }
}