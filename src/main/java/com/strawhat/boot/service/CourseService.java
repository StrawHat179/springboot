package com.strawhat.boot.service;

import com.strawhat.boot.pojo.Course;

import java.util.HashMap;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    List<Course> getCanselectCourse();
    Course getCourseBycId(Integer cId);
    int selectCourse(HashMap<String,Object> map);
    int updateCourse(Integer courseCID);
    List<Course> queryCourse(HashMap<String,Object> map);
    int editCourse(Course course);
    boolean courseAdd(Course course);
    boolean removeCourse(String courseNo);

}
