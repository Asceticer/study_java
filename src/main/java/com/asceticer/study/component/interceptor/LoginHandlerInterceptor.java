package com.asceticer.study.component.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

/**
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2020/3/19 9:21
 * @Version: 1.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      Object user = request.getSession().getAttribute("username");
      if (user == null) {
          request.setAttribute("message", "没有权限，请先登录");
          request.getRequestDispatcher("/index").forward(request, response);
          return false;
      } else {
          return true;
      }
    }
}
