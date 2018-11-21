package com.springcloud.test.controller;

import com.springcloud.test.common.ListResult;
import com.springcloud.test.common.ModelResult;
import com.springcloud.test.entity.User;
import com.springcloud.test.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-19 13:50
 * @Company www.midea.com
 */
@RestController
@RequestMapping("/api")
@Api(description = "用户")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService iUserService;

    @ApiOperation(value = "根据姓名查询用户")
    @RequestMapping(value = "/findUserByUsernameLike", method = RequestMethod.GET)
    public ListResult<User> findUserByUsernameLike(@ApiParam("用户姓名") @RequestParam(value = "name") String name) {
        logger.info("findUserByUsernameLike|name={}", name);
        return iUserService.findUserByUsernameLike(name);
    }

    @ApiOperation(value = "根据id查询用户")
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public ModelResult<User> getUserById(@ApiParam("用户id")@RequestParam(value = "id") Integer id) {
        return iUserService.getUserById(id);
    }

    @ApiOperation(value = "保存用户")
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelResult saveUser(@ApiParam("用户信息")@RequestBody User user) {
        logger.info("addUser|user={}", user);
        return iUserService.saveUser(user);
    }

}
