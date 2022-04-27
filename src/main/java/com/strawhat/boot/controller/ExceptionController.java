package com.strawhat.boot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
//用一个类封装所有需要的异常
//@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value={ArrayIndexOutOfBoundsException.class})
    public String arrayException(Exception e, Model model){
        model.addAttribute("msg",e);
        return "allException";
    }

    @ExceptionHandler(value={NullPointerException.class})
    public String nullException(Exception e,Model model) {
        model.addAttribute("msg",e);
        return "allException";

    }

}
