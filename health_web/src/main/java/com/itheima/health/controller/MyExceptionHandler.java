package com.itheima.health.controller;

import com.itheima.health.entity.Result;
import com.itheima.health.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一处理异常
 * 必须在扫包的目录下
 */
@RestControllerAdvice
public class MyExceptionHandler {
    /**
     * info:记录执行的过程
     * debug:记录执行过程中重要的key
     * error:记录异常信息
     *
     */
    private static final Logger log = LoggerFactory.getLogger(MyException.class);

    /**
     * 捕获异常
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public Result handleMyException(MyException e){
        return new Result(false,e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        log.error("发生未知异常",e);
        return new Result(false,"发生未知异常,请联系管理员");
    }
}
