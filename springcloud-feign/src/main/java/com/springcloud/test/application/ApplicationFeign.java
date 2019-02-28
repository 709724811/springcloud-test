package com.springcloud.test.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-19 13:39
 * @Company www.midea.com
 */
@SpringBootApplication(scanBasePackages = {"com.springcloud.test"})
@EnableSwagger2
@EnableFeignClients({"com.springcloud.test.api"})
@EnableEurekaClient
public class ApplicationFeign {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationFeign.class, args);
    }
}
