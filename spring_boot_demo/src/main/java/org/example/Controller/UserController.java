package org.example.Controller;

import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user") //设置想要跳转的父路径
/**
 * @RequestMapping 是一个用来处理请求地址映射的注解，可用于类或方法上。
 * 用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径；
 * 用于方法上，表示在类的父路径下追加方法上注解中的地址将会访问到该方法，
 * 此处需注意@RequestMapping用在类上可以没用，但是用在方法上必须有
 */
public class UserController {
    @Data
    @Accessors(chain = true)
    class User {
        private String name;
        private Integer age;
    }

    /**
     * 个人资源
     * @return
     */
    @RequestMapping("/getUserInfo") // 设置方法下的子路经
    public User getUserInfo(){
        return new User().setName("User:zs").setAge(12);
    }

    /**
     * 隐私资源
     *
     * @return
     */
    @RequestMapping("/getUserPrivateInfo")
    public User getUserPrivateInfo() {
        return new User().setName("PrivateUser:ls").setAge(2);
    }

    /**
     * 公开资源
     *
     * @return
     */
    @RequestMapping("/getUserPublicInfo")
    public User getUserPublicInfo() {
        return new User().setName("PublicUser:ww").setAge(15);
    }

    /**
     * 未授权跳转页面
     *
     * @return
     */
    @RequestMapping("/noAuth")
    public String noAuth() {
        return "You were intercepted~";
    }

}
