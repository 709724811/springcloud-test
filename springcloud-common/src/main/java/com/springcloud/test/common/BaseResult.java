package com.springcloud.test.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.springcloud.test.enums.ResultCodeEnum;

import java.io.Serializable;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-20 9:30
 * @Company www.midea.com
 */
public class BaseResult implements Serializable {

    private Integer code = 0;

    private String errorMsg;

    public void withError(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getIndex();
        this.errorMsg = resultCodeEnum.getDescription();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        SerializerFeature[] serializerFeatures = new SerializerFeature[]{SerializerFeature.WriteMapNullValue,
                SerializerFeature.UseISO8601DateFormat};
        return JSON.toJSONString(this, serializerFeatures);
    }

}
