package com.strawhat.boot.aspect;

import com.strawhat.boot.controller.BaseController;
import com.strawhat.boot.pojo.LogBean;
import com.strawhat.boot.pojo.User;
import com.strawhat.boot.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

//切面类
@Aspect//切面注解
@Component
@Slf4j
public class LogAspect extends BaseController {
    @Autowired
    private LogService logService;

    //切入点用于统一管理表达式
    //@Pointcut("execution(* com.iflytek.service.impl.UserServiceImpl.*(..))")
    @Pointcut("@annotation(com.strawhat.boot.aspect.LogAnnotation)")
    public void pointcut(){

    }

    @Before("pointcut()&&@annotation(logAnnotation)")//在业务代码执行前执行日志代码
    public void beforeLog(JoinPoint joinPoint, LogAnnotation logAnnotation){
        //String method = joinPoint.getSignature().getName();//获取连接点方法的名字
        //Object[] args = joinPoint.getArgs();//获取方法中参数
        //通拦截连接点后执行如下新增日志的代码
        User user = getAccount();//获取session中存储的当前用户信息
        String url = getRequest().getRequestURI();//获取请求中的路径
        LogBean logs = new LogBean();
        logs.setDate(new Date());
        logs.setUrl(url);
        logs.setModule(logAnnotation.module());
        logs.setDescription(logAnnotation.description());
        logs.setUserAccount(user.getAccount());
        logs.setUserName(user.getName());
        logService.insertLog(logs);
       // log.info(method +"--"+new Date()+"--"+logAnnotation.module()+"执行了"+logAnnotation.description()+"方法");
    }

    /*@After("pointcut()&& @annotation(logAnnotation)")
    public void afterLog(LogAnnotation logAnnotation){
        LogBean log = new LogBean();
        //log.info(new Date()+"--"+logAnnotation.module()+"执行了"+logAnnotation.description()+"方法");
    }*/
}
