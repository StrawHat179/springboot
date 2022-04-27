package com.strawhat.boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.strawhat.boot.pojo.LogBean;

import java.util.List;

public interface LogService {
    //查询所有的日志
    List listLog();

    //插入日志
    boolean insertLog(LogBean log);

    //批量删除日志
    boolean deleteLog(List<String> ids);

    //根据条件查询
    List<LogBean> queryLog(QueryWrapper queryWrapper);
}
