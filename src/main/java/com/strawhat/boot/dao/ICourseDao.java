package com.strawhat.boot.dao;

import com.strawhat.boot.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * The interface Course dao.
 */
@Mapper
public interface ICourseDao {
    List<Course> getAllCourse();


    /**
     * Gets course byc id.
     *根据课程ID查询课程
     * @param cId the c id
     * @return the course byc id
     */
    Course getCourseBycId(Integer cId);
    /**
     * Gets canselect course.
     *查询当前时间可选同时人数还有剩余的课程
     * @return the canselect course
     */
    List<Course> getCanselectCourse();


    /**
     * Query course course.
     *
     * @param map the map
     * @return the course
     */
    List<Course> queryCourse(HashMap<String,Object> map);
    /**
     * Select course int.
     *执行选课，将选课数据插入到user_c(用户课程关联表)表中
     * @param map the map
     * @return the int
     */
    int selectCourse(HashMap<String,Object> map);

    /**
     * Update course int.
     *选课之后，课程表数据更新
     * @param courseCID the course cid
     * @return the int
     */
    int updateCourse(Integer courseCID);

    /**
     * Edit course int.
     *编辑更新课程信息
     * @param course the course
     * @return the int
     */
    int editCourse(Course course);

    /**
     * Course add int.
     *添加课程
     * @param course the course
     * @return the int
     */
    int courseAdd(Course course);
    int deleteCourse(String courseNo);
}
