package com.strawhat.boot.pojo;

import lombok.Data;

@Data
public class UserCourseRelation {
    private Integer id;//选课主键
    private String account;//账号
    private String courseNo;//课程编号
}

/**
 * 作业任务：
 * 1、完成课程的增删改查；
 * 2、完成选课操作：
 *      2.1 如果学生选课时间不在报考时间范围的话不允许选课；
 *      2.2 如果选课人数已达到上限，也不给选课。
 *      2.3 选课成功后选课人数加一；
 *要求：
 * 使用数据库存储数据；使用mybait操作数据；
 */