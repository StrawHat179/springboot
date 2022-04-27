package com.strawhat.boot.controller;

import com.strawhat.boot.pojo.Course;
import com.strawhat.boot.pojo.User;
import com.strawhat.boot.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * The type User controller.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @RequestMapping("/queryUser")
    public String queryUser(Model model){
        List<User> userList = userService.queryUser();
        model.addAttribute("userList",userList);
        return "user-list";
    }


    /**
     * Add user view string.
     *跳转到新增页面
     * @return the string
     */
    @RequestMapping("/addUserView")
    public String addUserView(){
        return "user-add";
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping("/insertUser")
    @ResponseBody
    public boolean insertUser(User user) {
        boolean rel;
        if (user.getAccount() == null || "".equals(user.getAccount())) {
            rel = false;
            return rel;
        } else {
            rel = userService.insertUser(user);
            return rel;
        }
    }
    /**
     * 跳转到编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/queryUserById/{id}")
    public String queryUserById(@PathVariable("id")String id, Model model){
        User user = userService.queryUserById(Integer.valueOf(id));
        model.addAttribute("user",user);
        return "user-edit";
    }

    /**
     * Query user by account string.
     *根据账号查询用户
     * @param account the account
     * @param model   the model
     * @return the string
     */
    @RequestMapping("/queryUserAccount/{account}")
    public String queryUserByAccount(@PathVariable("account")String account, Model model){
        User user = userService.queryUserByAccount(account);
        model.addAttribute("user",user);
        return "user-list";
    }
    /**
     * 用户删除
     * @param id
     * @return
     */
    @PostMapping("/deleteUser")
    @ResponseBody
    public boolean deleteUser(Integer id){
        return userService.deleteUser(id);
    }


    /**
     * Edit user boolean.
     *更新用户信息
     * @param user the user
     * @return the boolean
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public boolean editUser(User user){
        return userService.updateUser(user);
    }

    /**
     * Query course string.
     *管理员查询选课信息
     * @param account the account
     * @param name    the name
     * @param model   the model
     * @return the string
     */
    @RequestMapping("/findMyselfCourse")
   public String queryMyCourse(String account,String name,Model model){
        HashMap<String,Object> map =new HashMap<>();
        if(account==null || name==null){
            map.put("account","admin");
            map.put("name","admin");
        }
        else{
            map.put("account",account);
            map.put("name",name);
        }
        User user= userService.queryCourseByAccount(map);
        System.out.println(user);
        List<Course> userCourses = user.getCourse();
       model.addAttribute("userCourses",userCourses);
        model.addAttribute("account",account);
        model.addAttribute("name",name);
       return "user_course";
   }

    /**
     * User query my course string.
     *登录用户查询选课信息
     * @param account the account
     * @param model   the model
     * @return the string
     */
    @RequestMapping("/userFindMyselfCourse")
    public String userQueryMyCourse(String account,Model model){
        HashMap<String,Object> map =new HashMap<>();
        map.put("account",account);
        User user= userService.queryCourseByAccount(map);
        System.out.println(user);
        List<Course> userCourses = user.getCourse();
        model.addAttribute("userCourses",userCourses);
        model.addAttribute("account",account);
        return "user_course1";
    }


    /**
     * Query by account or name string.
     *根据输入的条件查询
     * @param account the account
     * @param model   the model
     * @return the string
     */
    @RequestMapping("/queryByAccount")
   public String queryByAccountORName(String account,String name,Model model) {
            HashMap<String,Object> map =new HashMap<>();
            account=StringUtils.deleteWhitespace(account);
            name= StringUtils.deleteWhitespace(name);
            map.put("account",account);
            map.put("name",name);
            List<User> userlist =userService.searchUser(map);
            model.addAttribute("userList",userlist);
            model.addAttribute("account",account);
            model.addAttribute("name",name);
            return "user-list";
   }
}
