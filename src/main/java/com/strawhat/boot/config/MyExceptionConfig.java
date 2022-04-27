package com.strawhat.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class MyExceptionConfig implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        if (ex instanceof ArrayIndexOutOfBoundsException) {
            mv.setViewName("allException");
        } else if (ex instanceof ArithmeticException) {
            mv.setViewName("allException");
        }
        mv.addObject("msg",ex.toString());
        return mv;
    }
}
