package org.sdsds222.testtlias.controller;

import lombok.extern.slf4j.Slf4j;
import org.sdsds222.testtlias.pojo.*;
import org.sdsds222.testtlias.service.LoginService;
import org.sdsds222.testtlias.service.UniAppService;
import org.sdsds222.testtlias.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/uniapp")
public class UniAppController {

    @Autowired
    private UniAppService uniAppService;


    @GetMapping("/navlist")
    public Result navList() {
        List<Nav> navList = uniAppService.navList();
        return Result.success(navList);
    }


    @GetMapping("/newslist")
    public Result newsList(@RequestParam("cid") Integer cid, // 获取 cid 参数
                           @RequestParam("num") Integer num, // 获取 num 参数
                           @RequestParam("page") Integer page // 获取 page 参数
    ) {
        List<News> newsList = uniAppService.newsList(cid, num, page);
        return Result.success(newsList);
    }


    @GetMapping("/detail")
    public Result detail(@RequestParam("cid") Integer cid, // 获取 cid 参数
                           @RequestParam("id") Integer id// 获取 num 参数
    ) {
        Detail detail = uniAppService.detail(cid, id);
        return Result.success(detail);
    }

    @PostMapping("/publish")
    public Result publish(@RequestBody PublishContent publishContent) {
        uniAppService.publish(publishContent);
        return Result.success("数据添加成功");
    }


    @PostMapping("/test")
    public Result test() {
        System.out.println("登录");
        return Result.success("LOGIN");
    }
}