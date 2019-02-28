package com.springcloud.test.api;

import com.springcloud.test.common.ListResult;
import com.springcloud.test.common.ModelResult;
import com.springcloud.test.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author LANRY
 * @Date 2019-1-23 13:57
 * @Company www.midea.com
 */
@FeignClient(name = "${provider.name}", path = "provider")
@RestController
@RequestMapping("/api")
@Api(description = "用户")
public interface UserControllerApi {


    @ApiOperation(value = "根据姓名查询用户")
    @RequestMapping(value = "/findUserByUsernameLike", method = RequestMethod.GET)
    ListResult<User> findUserByUsernameLike(@ApiParam("用户姓名") @RequestParam(value = "name") String name);

    @ApiOperation(value = "根据id查询用户")
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    ModelResult<User> getUserById(@ApiParam("用户id") @RequestParam(value = "id") Integer id);

    @ApiOperation(value = "保存用户")
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    ModelResult saveUser(@ApiParam("用户信息") @RequestBody User user);
}
