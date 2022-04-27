package com.strawhat.boot.config;

import com.strawhat.boot.conveter.MyDateConveter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//重新设置我们的首页，通过配置的方式
@Configuration
public class IndexWebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    //注册自定义时间转换器
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new MyDateConveter("yyyy-MM-dd"));
        //registry.addConverter(new MyDateConveter("yyyy-MM-dd HH:mm"));
    }
}
