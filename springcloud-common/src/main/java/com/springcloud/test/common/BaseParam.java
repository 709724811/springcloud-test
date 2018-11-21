package com.springcloud.test.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * @Description
 * @Author LANRY
 * @Date 2018-11-20 9:30
 * @Company www.midea.com
 */
public class BaseParam implements Serializable {

    @Override
    public String toString() {
        SerializerFeature[] serializerFeatures = new SerializerFeature[]{SerializerFeature.WriteMapNullValue,
                SerializerFeature.UseISO8601DateFormat};
        return JSON.toJSONString(this, serializerFeatures);
    }

}
