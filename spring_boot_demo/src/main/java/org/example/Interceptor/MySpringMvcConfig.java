package org.example.Interceptor;

import org.example.Handler.WebInterceptorHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * 拦截器配置
 */
@Configuration
public class MySpringMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 注入自定义拦截器
     */
    @Resource
    private WebInterceptorHandler webInterceptorHandler;

    /**
     * 配置拦截器和拦截、放行路径
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webInterceptorHandler) //用于添加你自定义的拦截器实例
                .excludePathPatterns("/user/getUserPublicInfo") //用于添加不需要拦截的url,可以写多个。
                .excludePathPatterns("/user/noAuth")
                .excludePathPatterns("/")
                .addPathPatterns("/**"); //用于添加要拦截的url,可以写多个。/**表示需要拦截所有请求
    }
}
