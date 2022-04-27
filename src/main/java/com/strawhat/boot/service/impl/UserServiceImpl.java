package com.strawhat.boot.service.impl;

import com.strawhat.boot.aspect.LogAnnotation;
import com.strawhat.boot.dao.IUserDao;
import com.strawhat.boot.pojo.User;
import com.strawhat.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    IUserDao userDao;

    @Override
    @LogAnnotation(module = "用户模块", description = "查询所有用户")
    public List<User> queryUser() {
        //执行before
        //log.info("操作了查询方法");
        return userDao.queryUser();

    }

    @Override
    public User queryUserByAccount(String account) {
        return userDao.queryUserByAccount(account);
    }

    @Override
    public User queryUserById(int id) {
        //log.info("操作了查询方法");
        return userDao.queryUserById(id);
    }


    @Override
    @LogAnnotation(module = "用户模块", description = "新增一个用户")
    public boolean insertUser(User user) {
        //log.info("操作了新增方法");
        int rel = userDao.insertUser(user);
        /*if (user.getAccount().length() <3 || user.getAccount().length() >6) {
            throw new RuntimeException("用户账号长度有误！");
        }*/
        return rel>0;
    }

    @Override
    @LogAnnotation(module = "用户模块", description = "删除一个用户")
    public boolean deleteUser(Integer id) {
        //log.info(new Date()+"操作了删除方法");
        return userDao.deleteUser(id)>0;
    }

    @Override
    @Transactional
    @LogAnnotation(module = "用户模块", description = "更新一个用户")
    public boolean updateUser(User user) {
    int rel1 = userDao.editUser(user);
      return rel1>0;
    }

    @Override
    public User queryCourseByAccount(HashMap<String,Object> map) {
        return userDao.findCourseByAccount(map);
    }

    @Override
    public List<User> searchUser(HashMap<String, Object> map) {
        return userDao.searchUser(map);
    }


}
