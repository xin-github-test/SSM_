package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProtalController {

    @RequestMapping("/")
    public String protal(){
        return "index";
    }
}