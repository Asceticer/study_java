package com.asceticer.study.component.resolver;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Description: 自定义Locale解析器
 * @Author: Administrator
 * @Date: 2020/3/18 14:29
 * @Version: 1.0
 */
public class DefinedLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String i = request.getParameter("i");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(i)) {
            String[] spilt = i.split("_");
            locale = new Locale(spilt[0], spilt[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
