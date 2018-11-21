package com.springcloud.test.service;


import com.springcloud.test.common.ListResult;
import com.springcloud.test.common.ModelResult;
import com.springcloud.test.entity.User;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-19 14:23
 * @Company www.midea.com
 */
public interface IUserService {

    /**
     * 模糊查询用户信息
     * @param name 用户姓名
     * @return
     */
    ListResult<User> findUserByUsernameLike(String name);

    /**
     * 根据用户id查询用户信息
     * @param id 用户id
     * @return
     */
    ModelResult<User> getUserById(Integer id);

    /**
     * 保存用户信息
     * @param user 用户信息
     * @return
     */
    ModelResult<Integer> saveUser(User user);

}
