package com.asceticer.study.component.attribute;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2020/3/25 13:20
 * @Version: 1.0
 */
@Component
public class DefinedErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("author", "shaopan");
        map.put("exception", webRequest.getAttribute("exception",0));
        map.put("ext", (Map<String, Object>)webRequest.getAttribute("ext",0));
       return map;
    }
}
