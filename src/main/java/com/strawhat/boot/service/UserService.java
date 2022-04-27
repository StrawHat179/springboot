package com.strawhat.boot.service;

import com.strawhat.boot.pojo.User;

import java.util.HashMap;
import java.util.List;


public interface UserService{
    //查询所有的用户信息
    List<User> queryUser();

    //根据账号查询
    User queryUserByAccount(String account);

    //根据信息查询用户
    User queryUserById(int id);

    boolean insertUser(User user);

    boolean deleteUser(Integer id);

    boolean updateUser(User user);
    //根据用户账号查询选课信息
    User queryCourseByAccount(HashMap<String,Object> map);

    List<User> searchUser(HashMap<String,Object> map);
}
