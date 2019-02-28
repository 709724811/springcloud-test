package com.springcloud.test.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-19 13:39
 * @Company www.midea.com
 */
@SpringBootApplication(scanBasePackages = {"com.springcloud.test.controller"
        , "com.springcloud.test.service"
        , "com.springcloud.test.mapper.interceptor"
        , "com.springcloud.test.configuration"})
@MapperScan(basePackages = {"com.springcloud.test.mapper"})
@ServletComponentScan
@EnableSwagger2
@EnableAsync
public class ApplicationProvider {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationProvider.class, args);
    }

    @Bean
    public Docket useApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(path -> path.startsWith("/api/"))
                .build();
    }

}
