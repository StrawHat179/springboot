package com.strawhat.boot.controller;

import com.strawhat.boot.pojo.User;
import com.strawhat.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
   private UserService userService;

    /**
     * 登录方法
     * @param userName--用户名
     * @param password--密码
     * @param model
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(String userName, String password, Model model, HttpSession session){
        User user = userService.queryUserByAccount(userName);
        if (user == null){
            model.addAttribute("msg","用户名错误");
            return "login";
        } else if(!user.getPassword().equals(password)){
            model.addAttribute("msg","密码错误");
            return "login";
        }
        model.addAttribute("name",user.getName());//把登录名传给前端
        session.setAttribute("usersession",user);
        return "index";
    }

}
