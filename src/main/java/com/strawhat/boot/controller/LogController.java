package com.strawhat.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.strawhat.boot.pojo.LogBean;
import com.strawhat.boot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * 日志管理controller
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    /**
     * 查询所有的日志信息并返回到页面
     * @return
     */
    @RequestMapping("/logList")
    public String logList(Model model){
        List<LogBean> logList = logService.listLog();
        model.addAttribute("logList",logList);
        return "log-list";
    }

    /**
     * 根据条件查询日志
     * @param model
     * @param userName
     * @return
     */
    @RequestMapping("/queryLog")
    public String queryLog(Model model,String userName){
        //构造了查询对象
        QueryWrapper<LogBean> queryWrapper = new QueryWrapper<LogBean>();

        // queryWrapper.between("age",33,45);
        //queryWrapper.eq("user_name",userName); //where user_name=admin
        queryWrapper.like("user_name",userName); //where user_name like %admin%
        //queryWrapper.like("user_account",userName); //where user_account like %admin%
        List<LogBean> logList = logService.queryLog(queryWrapper);
        model.addAttribute("logList",logList);
        //查询参数回显到前端
        model.addAttribute("userName",userName);
        return "log-list";
    }

    /**
     * 批量删除日志数据
     * @param ids
     * @return
     */
    @RequestMapping("/batchdelLog")
    @ResponseBody
    public boolean batchdelLog(String ids){
        if ("".equals(ids)){
            return false;
        }
        return logService.deleteLog(Arrays.asList(ids.split(",")));

    }

}
