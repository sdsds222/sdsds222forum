package org.sdsds222.testtlias.controller;

import lombok.extern.slf4j.Slf4j;
import org.sdsds222.testtlias.pojo.Result;
import org.sdsds222.testtlias.pojo.User;
import org.sdsds222.testtlias.service.LoginService;
import org.sdsds222.testtlias.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //前端发送post请求时以form-data的形式的请求体传输username和password，可以直接接收，json格式的需要用对象并加上@RequestBody注解接收
    @PostMapping
    public Result login(@RequestBody User user) {
        if (user.getUsername().equals("") || user.getPassword().equals("")) {
            return Result.error("NOT_LOGIN");
        }

        //校验账号密码是否存在
        if (!loginService.login(user)) {
            System.out.println("登录失败");
            return Result.error("NOT_LOGIN");
        }
        //生成一个Jwt令牌并返回
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        String jwt = JwtUtils.createJwt("sdsds222", claims);
        return Result.success(jwt);
    }
}
