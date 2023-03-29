package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 获取请求参数的方式
 * 1.通过servletAPI来进行获取（用的不多）
 *      只需要在控制器方法的形参位置设置 HttpServletRequest 类型的形参，就可以在控制器方法中
 *      使用request对象获取请求参数
 * 2.通过控制器方法的形参来获取请求参数
 *      只需要在控制器方法的形参位置，设置一个形参，形参的名字要和请求参数的名字一致即可
 * 3.@RequestParam:
 *      作用：将请求参数和控制器方法的形参绑定
 *      @RequestParam注解的三个属性：
 *      1)value:设置和形参绑定的请求参数的名字
 *      2)required:设置是否必须传输value所对应的请求参数，默认值为true
 *      3)defaultValue:设置当没有传输value所对应的请求参数时，为形参设置的默认值，此时和required属性值无关
 * 4.@RequestHeader:将请求头信息和控制器方法的形参绑定
 * 5.@CookieValue：将cookie数据和控制器方法的形参绑定
 * 6.通过控制器方法的实体类类型的形参获取请求参数
 *      需要在控制器方法的形参位置设置实体类类型的形参，但是要保证实体类中的属性的属性名和请求参数的名字一致
 *      然后就可以通过实体类类型的形参获取请求参数
 * 7.解决获取请求参数的乱码问题
 *      注意：处理编码的过滤器一定要设置在其他过滤器之前（和web.xml中配置filter-mapping的顺序有关）
 */
@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(
            //其中还有一个required 属性，默认值为true,即请求参数中必须得有名为userName的参数，否则报400
            //设置为false则可有可无，有则赋值，无则Null
            //defaultValue:给对应的请求参数设置一个默认值，若请求参数中没有该参数，则会给其赋值默认值，而不会报错
            @RequestParam(value = "userName",required = false,defaultValue = "default") String username, //使用@RequestParam将请求参数与形参绑定
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionId){
        System.out.println("username:"+username+",password:"+password);
        System.out.println("referer:"+referer);
        System.out.println(jsessionId);
        return "success";
    }
    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){ //可以直接将请求参数包装到实体类中，前提实体类中的属性名要和请求参数名称一致
        System.out.println(user);
        return "success";
    }

}
