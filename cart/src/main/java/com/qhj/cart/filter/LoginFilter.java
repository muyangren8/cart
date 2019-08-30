package com.qhj.cart.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qhj.cart.domain.ChartResult;
import com.qhj.cart.util.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/**", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${cartSeverHost}")
    private String cartSeverHost;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("post".equalsIgnoreCase(method)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String token = httpServletRequest.getParameter("token");
            System.out.println(token);
            if (this.check(token)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setContentType("application/json;charset=utf-8");
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(JSON.toJSONString(new ChartResult(-1, "未登录", null)));
            }
        }
    }

    private boolean check(String jwt) {
        try {
            if (jwt == null || jwt.trim().length() == 0) {
                return false;
            }
//            JSONObject object = HttpClient.get("http://localhost:8080/sso/checkJwt?token=" + jwt);
            JSONObject object = HttpClient.get(cartSeverHost + "/sso/checkJwt?token=" + jwt);
            return object.getBoolean("data");
        } catch (Exception e) {
            logger.error("向认证中心请求失败", e);
            return false;
        }

    }
}
