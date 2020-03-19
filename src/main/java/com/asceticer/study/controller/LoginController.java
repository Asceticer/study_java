package com.asceticer.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2020/3/18 16:02
 * @Version: 1.0
 */
@Controller
@RequestMapping()
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                        ModelMap map, HttpSession session){
        if ("admin".equals(userName) && "123456".equals(password)) {
            session.setAttribute("username", userName);
            return "redirect:/main";
        } else {
            map.put("message", "账号或密码错误");
            return "index";
        }
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
