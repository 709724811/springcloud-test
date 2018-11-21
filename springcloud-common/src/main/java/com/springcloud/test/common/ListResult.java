package com.springcloud.test.common;

import java.util.List;

/**
 * @Description 返回list结果
 * @Author LANRY
 * @Date 2018-11-20 9:32
 * @Company www.midea.com
 */
public class ListResult<T> extends BaseResult {

    private List<T> result;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
