package com.asceticer.study.component.Handler;

import com.asceticer.study.HelloException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DefinedExceptionHandler
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2020/3/24 0024 20:56
 * @Version: 1.0
 */
@ControllerAdvice
public class DefinedExceptionHandler {

    @ExceptionHandler(HelloException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,String> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code","500");
        map.put("ecoding", "utf-8");
        map.put("message", "天天向上");
        return "forward:/error";
    }
}
