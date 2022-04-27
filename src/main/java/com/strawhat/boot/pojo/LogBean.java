package com.strawhat.boot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_log")
public class LogBean {
    @TableId(value = "id",type = IdType.NONE)
    private String id;//id
    private Date date;//时间
    private String userAccount;//用户账户
    private String userName;//用户名字
    private String url;// 访问的地址
    private String module;//模块
    private String description;//描述
}
