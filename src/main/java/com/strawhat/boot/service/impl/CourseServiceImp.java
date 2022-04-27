package com.strawhat.boot.service.impl;

import com.strawhat.boot.dao.ICourseDao;
import com.strawhat.boot.pojo.Course;
import com.strawhat.boot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    private ICourseDao iCourseDao ;

    @Override
    public List<Course> getAllCourse() {
        return iCourseDao.getAllCourse();
    }

    @Override
    public List<Course> getCanselectCourse() {
        return iCourseDao.getCanselectCourse();
    }

    @Override
    public Course getCourseBycId(Integer cId) {
        return iCourseDao.getCourseBycId(cId);
    }

    @Override
    public int selectCourse(HashMap<String, Object> map) {
        return iCourseDao.selectCourse(map);
    }

    @Override
    public int updateCourse(Integer courseCID) {
        return iCourseDao.updateCourse(courseCID);
    }

    @Override
    public List<Course> queryCourse(HashMap<String, Object> map) {
        return iCourseDao.queryCourse(map);
    }

    @Override
    public int editCourse(Course course) {
        return iCourseDao.editCourse(course);
    }

    @Override
    public boolean courseAdd(Course course) {
        return iCourseDao.courseAdd(course)>0;
    }

    @Override
    public boolean removeCourse(String courseNo) {
        return iCourseDao.deleteCourse(courseNo)>0;
    }

}
