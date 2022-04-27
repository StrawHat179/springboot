package com.strawhat.boot.aspect;

import java.lang.annotation.*;

//@Target注解	功能：指明了修饰的这个注解的使用范围，即被描述的注解可以用在哪里。
//@Retention注解 功能：指明修饰的注解的生存周期，即会保留到哪个阶段。
//@Documented注解只是用来做标识，没什么实际作用，了解就好。
//.@interface自定义注解
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    /**模块*/
    String module() default "";

    /**描述*/
    String description() default "";
}
