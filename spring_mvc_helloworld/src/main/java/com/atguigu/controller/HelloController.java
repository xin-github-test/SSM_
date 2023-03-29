package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloController {

    @RequestMapping("/")  //"/" 会被服务器解析成 http://localhost:8080/ + 服务器项目名称
    public String protal(){
//        将逻辑视图返回  逻辑视图+视图解析器的前缀+视图解析器的后缀 = 跳转的页面
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
