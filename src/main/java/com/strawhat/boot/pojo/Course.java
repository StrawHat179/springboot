package com.strawhat.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("Course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer cId;//主键
    private String courseNo;//课程编号
    private String courseName;//课程名称
    private String classPlace;//上课地点
    private String classDate;//上课时间《如周一上午1,2节课;周三上午3,4节课;1-7周
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;//报考开始时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;//报考结束时间
    private double credits;//学分 如：3.0
    private int optional;//可选人数
    private int selected;//已选人数
    private String remark;//课程说明


}
