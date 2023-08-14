package org.example.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ValueYamlControllerDemo {
    @Value("${filename}") //代码需要使用@Value("${xxx}")注解来获取这些属性
    private String fileName;

    @Value("${isFile}")
    private Boolean isFile;

    @Value("${filePath}")
    private static String filePath;
    //无法读取static

    @Value("${test1.test2.test3:#{null}}")
    private String host;

    @RequestMapping("valueYaml")
    @ResponseBody
    public String getYamlValue(){
        return "filename: "+fileName+", isFile:"+isFile+", filePath: "+filePath+", host: "+host;
        // filename:test,isFile:false,filePath:null
    }
}
