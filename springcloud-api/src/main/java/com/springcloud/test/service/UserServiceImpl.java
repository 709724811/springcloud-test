package com.springcloud.test.service;

import com.springcloud.test.common.ListResult;
import com.springcloud.test.common.ModelResult;
import com.springcloud.test.entity.User;
import com.springcloud.test.enums.RPCServiceNameEnum;
import com.springcloud.test.enums.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-21 10:57
 * @Company www.midea.com
 */
@Service
public class UserServiceImpl implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ListResult<User> findUserByUsernameLike(String name) {
        ListResult<User> result = new ListResult<>();
        try {
            Map<String, String> paramMap = new HashMap<>(1);
            paramMap.put("name", name);
            result = restTemplate.getForObject("http://" + RPCServiceNameEnum.USER_PROVIDER.getName() + "/api/findUserByUsernameLike?name={name}", ListResult.class, paramMap);
            logger.info("findUserByUsernameLike|name={},result={}", name, result);
            if (result == null || CollectionUtils.isEmpty(result.getResult())) {
                result.withError(ResultCodeEnum.FAILED);
            }
        } catch (Exception e) {
            logger.error("findUserByUsernameLike|RPC Error.name={}", name, e);
            result.withError(ResultCodeEnum.FAILED);
        }
        return result;
    }

    @Override
    public ModelResult<User> getUserById(Integer id) {
        ModelResult<User> result = new ModelResult<>();
        try {
            Map<String, Integer> paramMap = new HashMap<>(1);
            paramMap.put("id", id);
            result = restTemplate.getForObject("http://" + RPCServiceNameEnum.USER_PROVIDER.getName() + "/api/getUserById?id={id}", ModelResult.class, paramMap);
            logger.info("getUserById|id={},result={}", id, result);
            if (result == null || result.getResult() == null) {
                result.withError(ResultCodeEnum.FAILED);
            }
        } catch (Exception e) {
            logger.error("getUserById|RPC ERROR.id={}", id);
            result.withError(ResultCodeEnum.FAILED);
        }
        return result;
    }

    @Override
    public ModelResult<Integer> saveUser(User user) {
        ModelResult<Integer> result = new ModelResult<>();
        try {
            result = restTemplate.postForObject("http://" + RPCServiceNameEnum.USER_PROVIDER.getName() + "/api/saveUser", user, ModelResult.class);
            logger.info("saveUser|user={},result={}", user, result);
            if (result == null || result.getResult() == null) {
                result.withError(ResultCodeEnum.FAILED);
            }
        } catch (Exception e) {
            logger.error("saveUser|RPC ERROR.user={}", user);
            result.withError(ResultCodeEnum.FAILED);
        }
        return result;
    }
}
