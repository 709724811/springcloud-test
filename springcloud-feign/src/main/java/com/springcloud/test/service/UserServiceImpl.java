package com.springcloud.test.service;

import com.springcloud.test.api.UserControllerApi;
import com.springcloud.test.common.ListResult;
import com.springcloud.test.common.ModelResult;
import com.springcloud.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-23 16:56
 * @Company www.midea.com
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserControllerApi userControllerApi;

    @Override
    public ListResult<User> findUserByUsernameLike(String name) {
        return userControllerApi.findUserByUsernameLike(name);
    }

    @Override
    public ModelResult<User> getUserById(Integer id) {
        return null;
    }

    @Override
    public ModelResult<Integer> saveUser(User user) {
        return null;
    }
}
