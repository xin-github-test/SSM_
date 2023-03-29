package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/**
 * 1.@RequestMapping该注解可以加在类上，也可以加在方法上
 *      加在类上为设置请求的基础信息，加在方法上设置请求的具体信息
 *      类上加上了注解之后，访问路径需要先匹配类上注解的标识内容
 * 2.@RequestMapping注解value属性
 *      作用：通过请求的请求路径匹配请求
 *      value属性是数组类型的，即当前浏览器所发送的请求的请求路径匹配value属性中的任何一个值，
 *      则当前请求就会被注解所标识的方法进行处理
 * 3.@RequestMapping注解的method属性
 *      作用：通过请求的请求方式匹配请求，即当前浏览器所发送的请求的请求方式匹配method属性中的任何
 *          一种请求方式，则当前请求就会被注解所标识的方法进行处理
 *      在@RequestMapping的基础上，结合请求方式的一些派生注解：
 *      @GetMapping, @PostMapping, @DeleteMapping, @PutMapping
 * 4.@RequestMapping注解的params属性
 *      作用：通过请求的请求参数来匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
 *      params可以使用四种表达式：
 *      1）"param" : 表示当前所匹配请求的请求参数中必须携带param参数
 *      2）"!param" : 表示当前所匹配请求的请求参数中一定不能携带param参数
 *      3）"param=value" : 表示当前所匹配请求的请求参数中必须携带param参数，且值必须为value
 *      4）"param!=value": 表示当前所匹配请求的请求参数中可以不携带param参数，若携带，参数的值一定不能是value
 * 5.@RequestMapping注解的headers属性(了解)
 *      注意：若当前请求满足注解中的value和method属性，但是不满足headers属性，此时页面显示404错误
 *      作用：通过请求的请求头信息匹配请求，即浏览器发送的请求的请求头信息必须满足headers属性的设置
 * 6.SpringMVC支持ant风格的路径：
 *      在@RequestMapping注解的value属性值中设置一些特殊字符：
 *          ?:任意的单个字符（不包括一些特殊字符，例如 ? 本身）
 *          *:任意个数的任意字符（不包括一些特殊字符，例如 ?，/ ）
 *          **:任意层数的任意目录 注意使用方式：只能**写在双斜线中，前后不能有任何的其他字符
 * 7.@RequestMapping注解使用路径中的占位符
 *      传统：/deleteUser?id=1
 *      rest:/user/delete/1
 *      使用rest风格需要在@RequestMapping注解的value属性值所设置的路径中，使用{xxx}的方式表示路径中的数据
 *      再通过@PathVariable注解，将占位符所表示的值和控制其方法的形参进行绑定
 */
//@RequestMapping("/test")
public class TestRequestMappingController {
    //此时控制器方法所匹配的请求的请求路径为 /test/hello
    @RequestMapping(
            value = {"/hello","/abc"},//其中value（默认）的属性值可以是数组，也就是说可以用于处理多个请求
            method = {RequestMethod.POST,RequestMethod.GET }, //只处理给定类型的请求,数组类型，可以匹配多个请求类型
            params = {"username","!password","age=20","gender!=女"}, //也是数组类型，若有多个则必须全部满足
            headers = {"referer"}
    )
    public String hello(){
        return "success";
    }
    @RequestMapping("/**/test/ant") //? 表示任意的字符，其中**只能 /**/ 这样使用
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id,@PathVariable("username") String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }
}
