package com.springcloud.test.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 打印系统信息
 *
 * @Description
 * @Author LANRY
 * @Date 2018-12-13 16:23
 * @Company www.midea.com
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static List<BeanDefined> printAllBeans() {
        List<BeanDefined> list = new ArrayList<>();
        String[] beans = SpringContextHolder.getApplicationContext()
                .getBeanDefinitionNames();
        for (String beanName : beans) {
            Class<?> beanType = SpringContextHolder.getApplicationContext()
                    .getType(beanName);
            Method[] methods = beanType.getDeclaredMethods();
            List<String> methodList = new ArrayList<>();
            for (Method method : methods) {
                methodList.add(method.getName());
            }
            BeanDefined beanDefined = new BeanDefined();
            beanDefined.setName(beanName);
            beanDefined.setType(beanType.getTypeName());
            beanDefined.setMathodNames(methodList);
            Package packages = beanType.getPackage();
            if (packages != null) {
                beanDefined.setPackageName(beanType.getPackage().getName());
            }
            list.add(beanDefined);
        }
        return list;
    }

}

