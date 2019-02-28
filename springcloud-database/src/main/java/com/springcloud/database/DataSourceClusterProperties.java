package com.springcloud.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author LANRY
 * @Date 2019-1-28 15:15
 * @Company www.midea.com
 */
@Component
@ConfigurationProperties(prefix = "spring.datacluster")
public class DataSourceClusterProperties implements Serializable {

    private List<NodeProperties> nodes;

    public List<NodeProperties> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeProperties> nodes) {
        this.nodes = nodes;
    }
}
