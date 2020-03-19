package com.asceticer.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2020/3/17 14:09
 * @Version: 1.0
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorld(Map map){
        map.put("hello", "<h2>你好！<h2>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "hello";
    }
}
