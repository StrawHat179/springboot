package com.strawhat.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 学生选课系统：
 * 1、系统有两个角色，学生和管理员；
 * 2、学生可以编辑自身信息、选课、查看已选课程、查看某个课程已选人员。
 * 3、管理员维护课程信息、维护学生信息。
 */
@TableName("tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uId;//id--主键
    private String account;//账号
    private String name;//名字
    private String dept;//所在班级(部门)
    private String gender;//性别
    private String password;//用户密码
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;//生日
    private  List<Course> course; //用户可选多门课程

//    public User() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getAccount() {
//        return account;
//    }
//
//    public void setAccount(String account) {
//        this.account = account;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDept() {
//        return dept;
//    }
//
//    public void setDept(String dept) {
//        this.dept = dept;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
//
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", account='" + account + '\'' +
//                ", name='" + name + '\'' +
//                ", dept='" + dept + '\'' +
//                ", gender='" + gender + '\'' +
//                ", password='" + password + '\'' +
//                ", birthday=" + birthday +
//                ", course=" + course +
//                '}';
//    }
}
