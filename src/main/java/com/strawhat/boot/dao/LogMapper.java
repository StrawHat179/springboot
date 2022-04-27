package com.strawhat.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.strawhat.boot.pojo.LogBean;
import org.apache.ibatis.annotations.Mapper;

/**
 * 写接口，继承BaseMapper
 * The interface Log mapper.
 */
@Mapper
public interface LogMapper extends BaseMapper<LogBean> {
}
