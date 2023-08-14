package org.example.Controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ConfigurationProperties(prefix = "http.pool")
//@ConfigurationProperties(prefix = "属性名前缀")这个注解作为配置文件中属性转对象属性的桥梁
public class PropertyYamlControllerDemo {
    /**
     * 最大连接数
     */
    private Integer maxTotal;
    /**
     * 路由是对最大连接数的细分
     * 每个路由基础的连接数
     */
    private Integer defaultMaxPerRoute;
    /**
     * 连接超时时间
     */
    private Integer connectTimeout;
    /**
     * 从连接池中获取连接的超时时间
     */
    private Integer connectionRequestTimeout;
    /**
     * 服务器返回数据(response)的时间
     */
    private Integer socketTimeout;

    public void setConnectionRequestTimeout(Integer connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setDefaultMaxPerRoute(Integer defaultMaxPerRoute) {
        this.defaultMaxPerRoute = defaultMaxPerRoute;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public void setSocketTimeout(Integer socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    @RequestMapping("propertyYaml")
    @ResponseBody
    public String getPropertyYaml() {
        return maxTotal + ", " + defaultMaxPerRoute + ", " + connectTimeout + ", " + connectionRequestTimeout +
                ", " + socketTimeout;
    }
}
