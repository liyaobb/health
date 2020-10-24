package com.itheima.health.exception;

/**
 * 自定义异常
 * 区分系统与业务异常
 * 给用户友好提示
 * 种植不符合逻辑的业务代码继续执行
 */
public class MyException extends RuntimeException{
    public MyException(String message){
        super(message);
    }
}
