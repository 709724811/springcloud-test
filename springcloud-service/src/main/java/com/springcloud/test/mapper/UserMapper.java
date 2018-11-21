package com.springcloud.test.mapper;

import com.springcloud.test.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description OR映射
 * @Author LANRY
 * @Date 2018-11-19 14:18
 * @Company www.midea.com
 */
@Mapper
public interface UserMapper {

    /**
     * 模糊查询
     *
     * @param name 姓名
     * @return
     */
    List<User> findUserByUsernameLike(String name);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 保存用户信息
     *
     * @param user 用户
     * @return 返回用户信息
     */
    Integer save(User user);
}
