package com.asceticer.study.exception;

/**
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2020/3/24 13:24
 * @Version: 1.0
 */
public class NotExsitException extends RuntimeException {

    public NotExsitException() {
        super("用户不存在！！！");
    }
}
