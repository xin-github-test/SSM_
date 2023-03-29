package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestViewController {

    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView(){

        return "success";
    }
    @RequestMapping("/test/view/forward")
    public String testInternalResourceView(){
        /**
         * 一般不用，因为配置了thymeleaf解析器之后，只有thymeleaf视图才会被解析，其他视图不会被解析
         * 其他
         */
        return "forward:/test/model"; //最后的视图不是thymeleaf视图，而是InternalResoverView
    }

    @RequestMapping("/test/view/redirect")
    public String testRedirectView(){
        return "redirect:/test/model";
    }
}
