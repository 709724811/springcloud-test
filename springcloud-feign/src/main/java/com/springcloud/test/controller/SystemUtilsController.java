package com.springcloud.test.controller;

import com.springcloud.test.bean.BeanDefined;
import com.springcloud.test.bean.SpringContextHolder;
import com.springcloud.test.common.ListResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Description
 * @Author LANRY
 * @Date 2018-12-13 17:49
 * @Company www.midea.com
 */
@RestController
@RequestMapping("/system")
@Api(description = "查询系统信息")
public class SystemUtilsController {

    @ApiOperation(value = "查询Spring 加载的Bean")
    @RequestMapping(value = "/queryBean", method = RequestMethod.GET)
    public ListResult<BeanDefined> queryBean() {
        ListResult<BeanDefined> result = new ListResult<>();
        List<BeanDefined> beanDefinedList = SpringContextHolder.printAllBeans();
        result.setResult(beanDefinedList);
        return result;
    }
}
