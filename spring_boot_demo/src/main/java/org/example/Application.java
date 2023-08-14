package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication //web应用的加载入口；SpringBoot项目的核心注解，主要目的是开启自动配置
@Controller
public class Application {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    //这个应用的入口
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);//启动该web应用
    }
}
