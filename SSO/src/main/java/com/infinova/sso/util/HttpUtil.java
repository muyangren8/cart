package com.infinova.sso.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HttpUtil {
    /**
     * Description: 从httprequest中的url参数/header/cookie中取某个值
     *
     */
    public static String getData(String key) {
        HttpServletRequest request = getRequest();
        String value = request.getHeader(key);
        if (value == null) {
            value = request.getParameter(key);
        }
        if (value == null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().toLowerCase().equals(key.toLowerCase())) {
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    public static HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getResponse();
    }
}
