package com.strawhat.boot.dao;

import com.strawhat.boot.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface IUserDao {

    /**
     * Query user list.
     *查询所有的用户信息
     * @return the list
     */
    List<User> queryUser();

    /**
     * Query user by id user.
     *根据ID查询用户
     * @param id the id
     * @return the user
     */
    User queryUserById(int id);

    /**
     * Query user by account user.
     *根据账号查询
     * @param account the account
     * @return the user
     */
    User queryUserByAccount(String account);

    /**
     * Insert user int.
     *添加用户
     * @param user the user
     * @return the int
     */
    int insertUser(User user);

    /**
     * Delete user int.
     *根据id删除用户
     * @param id the id
     * @return the int
     */
    int deleteUser(Integer id);

    /**
     * Find course by account user.
     *查询选课信息
     * @param map the map
     * @return the user
     */

   User findCourseByAccount(HashMap<String,Object> map);

    /**
     * Edit user int.
     *编辑用户信息
     * @param user the user
     * @return the int
     */
    int editUser(User user);

    /**
     * Search user list.
     *根据条件动态查询
     * @param map the map
     * @return the list
     */
    List<User> searchUser(HashMap<String,Object> map);
}
