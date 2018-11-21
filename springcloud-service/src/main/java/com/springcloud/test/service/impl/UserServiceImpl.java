package com.springcloud.test.service.impl;

import com.springcloud.test.common.ListResult;
import com.springcloud.test.common.ModelResult;
import com.springcloud.test.entity.User;
import com.springcloud.test.enums.ResultCodeEnum;
import com.springcloud.test.mapper.UserMapper;
import com.springcloud.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description  用户服务
 * @Author LANRY
 * @Date 2018-11-19 14:24
 * @Company www.midea.com
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ListResult<User> findUserByUsernameLike(String name) {
        ListResult<User> result = new ListResult<>();
        List<User> userList =  userMapper.findUserByUsernameLike(name);
        result.withError(ResultCodeEnum.SUCCESS);
        result.setResult(userList);
        return result;
    }

    @Override
    public ModelResult<User> getUserById(Integer id) {
        ModelResult<User> result = new ModelResult<>();
        User user = userMapper.getUserById(id);
        result.withError(ResultCodeEnum.SUCCESS);
        result.setResult(user);
        return result;
    }

    @Override
    public ModelResult<Integer> saveUser(User user) {
        ModelResult<Integer> result = new ModelResult<>();
        Integer rlt = userMapper.save(user);
        result.withError(ResultCodeEnum.SUCCESS);
        result.setResult(user.getId());
        return result;
    }
}
