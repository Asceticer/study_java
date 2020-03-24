package com.asceticer.study;

/**
 * @ClassName: HelloException
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2020/3/24 0024 20:17
 * @Version: 1.0
 */
public class HelloException extends RuntimeException {

    public HelloException() {
        super("你好错了！！！");
    }
}
