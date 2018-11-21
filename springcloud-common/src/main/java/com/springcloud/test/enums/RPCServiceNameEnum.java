package com.springcloud.test.enums;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-21 13:38
 * @Company www.midea.com
 */
public enum  RPCServiceNameEnum {

    USER_PROVIDER(1,"springcloud-provider","用户服务提供者");

    RPCServiceNameEnum(int index, String name,String description){
        this.index = index;
        this.name = name;
        this.description = description;
    }
    private int index;

    private String name;

    private String description;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
