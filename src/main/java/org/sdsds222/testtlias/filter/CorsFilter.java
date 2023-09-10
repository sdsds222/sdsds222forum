package org.sdsds222.testtlias.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
@WebFilter("/*")
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有域
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*"); // 允许所有HTTP方法
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*"); // 允许所有请求头
        chain.doFilter(request, response);
    }
}
