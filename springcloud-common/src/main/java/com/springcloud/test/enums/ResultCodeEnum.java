package com.springcloud.test.enums;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-20 9:38
 * @Company www.midea.com
 */
public enum ResultCodeEnum {
    SUCCESS(0,"success"),
    FAILED(-1,"failed")
    ;

    ResultCodeEnum(int index, String description){
        this.index = index;
        this.description = description;
    }
    private int index;
    private String description;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
