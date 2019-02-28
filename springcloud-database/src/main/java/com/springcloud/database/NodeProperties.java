package com.springcloud.database;

import java.io.Serializable;

/**
 * @Description
 * @Author LANRY
 * @Date 2019-1-28 15:16
 * @Company www.midea.com
 */
public class NodeProperties implements Serializable {
    /**
     *  name: mainNode
     *       writeHost: datasource_if
     *       readHost: datasource_if
     *       isDefault: true
     */
    private String name;
    private String writeHost;
    private String readHost;
    private boolean isDefault;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriteHost() {
        return writeHost;
    }

    public void setWriteHost(String writeHost) {
        this.writeHost = writeHost;
    }

    public String getReadHost() {
        return readHost;
    }

    public void setReadHost(String readHost) {
        this.readHost = readHost;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
