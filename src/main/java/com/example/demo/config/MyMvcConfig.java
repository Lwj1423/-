package com.example.demo.config;

import com.example.demo.component.LoginHandlerInterceptor;
import com.example.demo.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 扩展SpringMVC配置类
 */
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/config").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer config = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                //请求重定向到main.html页面
                registry.addViewController("/main.html").setViewName("dashboard");
            }


        };
        return config;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
