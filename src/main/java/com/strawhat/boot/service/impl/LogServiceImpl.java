package com.strawhat.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.strawhat.boot.dao.LogMapper;
import com.strawhat.boot.pojo.LogBean;
import com.strawhat.boot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;
    @Override
    public List listLog() {
        return logMapper.selectList(null);
    }

    @Override
    public boolean insertLog(LogBean log) {
        return logMapper.insert(log) >0;
    }

    @Override
    public boolean deleteLog(List<String> ids) {
        return logMapper.deleteBatchIds(ids) >0;
    }

    @Override
    public List<LogBean> queryLog(QueryWrapper queryWrapper) {
        return logMapper.selectList(queryWrapper);
    }
}
