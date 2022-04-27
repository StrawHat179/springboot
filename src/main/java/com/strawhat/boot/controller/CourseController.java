package com.strawhat.boot.controller;

import com.strawhat.boot.pojo.Course;
import com.strawhat.boot.pojo.User;
import com.strawhat.boot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService ;

    /**
     * Query course string.
     *查询所有课程
     * @param model the model
     * @return the string
     */
    @RequestMapping("/queryCourseAll")
    public String queryCourseAll(Model model){
        List<Course> courseList =courseService.getAllCourse();
        model.addAttribute("courseList",courseList) ;
        return "course_list" ;
    }

    /**
     * Query course by id string.
     *根据ID查询课程
     * @param cId   the c id
     * @param model the model
     * @return the string
     */
    @RequestMapping("/queryCourseById/{cId}")
    public String queryCourseById(@PathVariable("cId")Integer cId,Model model){
        Course course =courseService.getCourseBycId(cId);
        model.addAttribute("course",course);
        return "course-edit";
    }

    /**
     * Add course view string.
     *跳转课程增加页面
     * @return the string
     */
    @RequestMapping("/addCourseView")
    public String addCourseView(){
        return "course-add";
    }
    /**
     * Course add boolean.
     *新增课程
     * @param course the course
     * @return the boolean
     */
    @RequestMapping("/addCourse")
    @ResponseBody
    public boolean courseAdd(Course course){
        boolean rel=courseService.courseAdd(course);
        return rel;
    }
    @PostMapping("/deleteCourse")
    @ResponseBody
    public boolean deleteCourse(String courseNo){
        boolean rel=courseService.removeCourse(courseNo);
        return rel;
    }
    /**
     * Edit course boolean.
     *编辑更新课程
     * @param course the course
     * @return the boolean
     */
    @RequestMapping("/editCourse")
    @ResponseBody
    public boolean editCourse(Course course){
      boolean rel= courseService.editCourse(course)>0;
        return rel ;
    }

    /**
     * Query course string.
     *根据条件查询课程
     * @param courseNo   the course no
     * @param courseName the course name
     * @param model      the model
     * @return the string
     */
    @RequestMapping("/queryCourse")
    public String queryCourse(String courseNo,String courseName, Model model){
        HashMap<String,Object> map =new HashMap<>();
        map.put("courseNo",courseNo);
        map.put("courseName",courseName);
        List<Course> courseList=courseService.queryCourse(map);
        model.addAttribute("courseList",courseList);
        model.addAttribute("courseNo",courseNo);
        model.addAttribute("courseName",courseName);
        return "course_list";
    }

    /**
     * Query can select course string.
     *查询当前时间可以选的课程
     * @param model the model
     * @return the string
     */
    @RequestMapping("/queryCanSelectCourse")
    public String queryCanSelectCourse(Model model){
        List<Course> courses =courseService.getCanselectCourse();
        model.addAttribute("courseList",courses);
         return "course_select_user";
    }
    @RequestMapping("/selectCourse")
    @ResponseBody
    public boolean selectCourse(String userAccount,Integer courseCID){
        boolean rel;
        HashMap<String,Object> map =new HashMap<>();
        if (userAccount == null || courseCID==null){
            rel = false;
            return rel;
        }
        else{
            map.put("userAccount",userAccount);
            map.put("courseCID",courseCID);
             rel= courseService.selectCourse(map)>0;
                  courseService.updateCourse(courseCID);
            return rel;
        }
    }
    @RequestMapping("/selectCourseUser")
    @ResponseBody
    public boolean selectCourseUser(Integer cId){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("usersession");
        String userAccount= user.getAccount();
        boolean rel;
        HashMap<String,Object> map =new HashMap<>();
        if (userAccount == null || cId==null){
            rel = false;
            return rel;
        }
        else{
            map.put("userAccount",userAccount);
            map.put("courseCID",cId);
            rel= courseService.selectCourse(map)>0;
            courseService.updateCourse(cId);
            return rel;
        }
    }
}
