package com.strawhat.boot.controller;

import com.strawhat.boot.pojo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * The type Base controller.
 *
 * @author CaoMao
 */
//封装了请求信息的获取
public class BaseController {
    private static final String  USER = "usersession";
    private static final String  Course = "course";

    public HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public User getAccount() {
        HttpSession session = getRequest().getSession();
        return (User) session.getAttribute(USER);
    }

    public void setAccount(User user) {
        HttpSession session = getRequest().getSession();
        if (user != null) {
            session.setAttribute(USER, user);
        }
    }


}
