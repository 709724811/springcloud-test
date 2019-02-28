package com.springcloud.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.midea.goms.redis.starter.GomsRedisService;
import com.midea.goms.redis.starter.RedisStatusEnum;
import com.springcloud.test.common.ListResult;
import com.springcloud.test.common.ModelResult;
import com.springcloud.test.entity.User;
import com.springcloud.test.enums.ResultCodeEnum;
import com.springcloud.test.mapper.UserMapper;
import com.springcloud.test.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 用户服务
 * @Author LANRY
 * @Date 2018-11-19 14:24
 * @Company www.midea.com
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GomsRedisService gomsRedisService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ListResult<User> findUserByUsernameLike(String name) {
        ListResult<User> result = new ListResult<>();
        List<User> userList = userMapper.findUserByUsernameLike(name);
        result.withError(ResultCodeEnum.SUCCESS);
        result.setResult(userList);
        return result;
    }

    @Override
    public ModelResult<User> getUserById(Integer id) {
        ModelResult<User> result = new ModelResult<>();
        String objectJson = gomsRedisService.get(String.valueOf(id));
        User user = JSONObject.parseObject(objectJson, User.class);
        if (user == null) {
            user = userMapper.getUserById(id);
            if (user != null) {
                String rlt = gomsRedisService.set(String.valueOf(id), JSONObject.toJSONString(user));
                boolean rltBoolean = RedisStatusEnum.resultToBooean(rlt);
                logger.info("getUserById|存入缓存,rltBoolean={}", rltBoolean);
            }
        }
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
