package com.springcloud.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Description
 * @Author LANRY
 * @Date 2019-1-28 15:19
 * @Company www.midea.com
 */
@Configuration
public class PropertiesTestConfig {

    @Autowired
    DataSourceClusterProperties dataSourceClusterProperties;

    @Bean
    public Integer integerSets(){
        List<NodeProperties> nodePropertiesList = dataSourceClusterProperties.getNodes();
        for(NodeProperties node:nodePropertiesList){
            System.out.println(node.getName());
            System.out.println(node.getReadHost());
            System.out.println(node.getWriteHost());
            System.out.println(node.getIsDefault());
        }
        return Integer.valueOf(1);
    }
}
