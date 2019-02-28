package com.springcloud.test.common;

import java.util.List;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-23 16:33
 * @Company www.midea.com
 */
public class DataPage<T> extends BaseResult {

    private List<T>  data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
