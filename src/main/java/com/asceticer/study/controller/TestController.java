package com.asceticer.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2020/4/20 14:53
 * @Version: 1.0
 */
@Controller
public class TestController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/query")
    public List query() {
       List list = jdbcTemplate.queryForList("select * from user_bike where gpsid = 620000612");
        return list;
    }
}
