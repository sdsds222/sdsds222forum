//package org.sdsds222.testtlias.filter;
//
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.sdsds222.testtlias.pojo.Result;
//import org.sdsds222.testtlias.utils.JwtUtils;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
////过滤器，拦截所有资源
//@Slf4j
//@WebFilter(urlPatterns = "/*")
//public class TestFilter implements Filter {
//    @Override//初始化的方法,只调用一次
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//        System.out.println("调用初始方法");
//    }
//
//    @Override//拦截到请求后调用，调用多次
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("过滤器拦截到请求");
////        //获取请求Url
////        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
////        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
////        //判断Url中是否包含login，如果包含则说明是登录操作，放行
////        String url = httpServletRequest.getRequestURL().toString();
////        log.info("请求的Url:{}", url);
////        if (url.contains("login")) {
////            log.info("登录操作，放行");
////            //放行
////            filterChain.doFilter(servletRequest, servletResponse);
////            return;
////        }
////        //否则获取请求头token中的令牌
////        String jwt = httpServletRequest.getHeader("token");
////        //判断令牌是否存在，如果不存在，返回错误结果（未登录）
////        if (!StringUtils.hasLength(jwt)) {
////            log.info("请求头token为空,返回未登录信息");
////            //将错误信息转换为json格式
////            String notLogin = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
////            httpServletResponse.getWriter().write(notLogin);
////            return;
////        }
////        //解析Jwt令牌，如果解析失败，则返回错误结果（未登录）
////        try {
////            JwtUtils.parseJwt(jwt, "sdsds222");
////        } catch (Exception e) {
////            e.printStackTrace();
////            log.info("解析令牌失败");
////            //将错误信息转换为json格式
////            String notLogin = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
////            httpServletResponse.getWriter().write(notLogin);
////            return;
////        }
////
////        //令牌合法，放行
////        log.info("令牌合法，放行");
//        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("过滤器放行");
//    }
//
//    @Override//销毁方法，只调用一次
//    public void destroy() {
//        Filter.super.destroy();
//        System.out.println("调用销毁方法");
//    }
//}
