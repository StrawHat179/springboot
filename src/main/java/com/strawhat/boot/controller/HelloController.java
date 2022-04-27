package com.strawhat.boot.controller;

import com.strawhat.boot.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@Slf4j
public class HelloController {

    //private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/log")
    @ResponseBody
    public String log(){
        log.warn("这是warn类型日志");
        log.info("这是info类型日志");
        log.trace("这是trace类型日志");
        log.debug("这是debug类型日志");
        log.error("这是error类型日志");
        return "sucess";

    }
    @RequestMapping("/hello")
    public String hello(Model model){
        //后台数据输出到前端的几种方式
        //model、modelAndView、map、原生的servlet的request请求
        model.addAttribute("msg","<h2>hello 这是text标签的使用</h2>");
        model.addAttribute("list", Arrays.asList("dog","cat","pig"));

        /*String[] arr = new String[]{"1","2"};
        String s1 = arr[2];*/

        //列表数据
        ArrayList<User> list = new ArrayList<User>();
        /*list.add(new User("1001","任嘉伦",30,"上海市","男"));
        list.add(new User("1001","任嘉伦2",30,"上海市","男"));
        list.add(new User("1001","任嘉伦3",30,"上海市","男"));
        list.add(new User("1001","任嘉伦4",30,"上海市","男"));
        list.add(new User("1002","任嘉伦5",30,"上海市","男"));
        list.add(new User("1002","任嘉伦6",30,"上海市","男"));*/
        model.addAttribute("userList",list);
        return "hello";
    }


    @RequestMapping("/fm")
    public ModelAndView hello1(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name","热巴");
        mv.addObject("sex","女");

        //列表数据
        ArrayList<User> list = new ArrayList<User>();
        /*list.add(new User("1001","任嘉伦",30,"上海市","男"));
        list.add(new User("1001","任嘉伦2",30,"上海市","男"));
        list.add(new User("1001","任嘉伦3",30,"上海市","男"));
        list.add(new User("1001","任嘉伦4",30,"上海市","男"));*/
        mv.addObject("userList",list);
        mv.setViewName("fm");
        return mv;
    }
}
