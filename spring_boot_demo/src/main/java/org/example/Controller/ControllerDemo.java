package org.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //标明这是一个SpringMVC的Controller控制器
public class ControllerDemo {
    @RequestMapping("hello")
    @ResponseBody
    /**
     * @Responsebody 注解表示该方法的返回的结果直接写入 HTTP 响应正文（ResponseBody）中，
     * 一般在异步获取数据时使用，通常是在使用 @RequestMapping 后，返回值通常解析为跳转路径，
     * 加上 @Responsebody 后返回结果不会被解析为跳转路径，而是直接写入HTTP 响应正文中
     */
    public String sayHello(){
        return "Hello World!";
    }
}
