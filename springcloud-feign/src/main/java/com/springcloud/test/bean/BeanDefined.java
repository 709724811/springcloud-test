package com.springcloud.test.bean;


import com.springcloud.test.common.BaseEntity;

import java.util.List;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-12-13 17:35
 * @Company www.midea.com
 */
public class BeanDefined extends BaseEntity{

    private String name;
    private String type;
    private String packageName;
    private List<String> mathodNames;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getMathodNames() {
        return mathodNames;
    }

    public void setMathodNames(List<String> mathodNames) {
        this.mathodNames = mathodNames;
    }
}
