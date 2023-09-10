package org.sdsds222.testtlias.interceptor;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.sdsds222.testtlias.pojo.Result;
import org.sdsds222.testtlias.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器，拦截Spring环境中的资源
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目标资源方法运行前放行,返回true放行，返回false不放行,拦截
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        System.out.println("拦截器拦截到请求");
        System.out.println("preHandle...");
        //当请求未找到匹配的控制器时，会重定向一个localhost:8080/error请求并被拦截器拦截
        //获取请求Url
        //判断Url中是否包含login，如果包含则说明是登录操作，放行
        String url = httpServletRequest.getRequestURL().toString();
        log.info("请求的Url:{}", url);
        if (url.contains("login") || url.contains("detail") || url.contains("navlist") || url.contains("newslist")) {
            log.info("登录操作，放行");
            //放行
            return true;
        }
        //否则获取请求头token中的令牌
        String jwt = httpServletRequest.getHeader("token");
        //判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空,返回未登录信息");
            //将错误信息转换为json格式
            //String notLogin = JSONObject.toJSONString(Result.error("NOT_LOGIN_JWT_ERROR"));
            String notLogin = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
            httpServletResponse.getWriter().write(notLogin);
            return false;
        }
        //解析Jwt令牌，如果解析失败，则返回错误结果（未登录）
        try {
            JwtUtils.parseJwt(jwt, "sdsds222");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败");
            //将错误信息转换为json格式
            //String notLogin = JSONObject.toJSONString(Result.error("NOT_LOGIN_JWT_TIMEOUT"));
            String notLogin = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
            httpServletResponse.getWriter().write(notLogin);
            return false;
        }

        //令牌合法，放行
        log.info("令牌合法，放行");
        System.out.println("拦截器放行");
        return true;
    }

    @Override//目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("hostHandle...");
    }

    @Override//视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
