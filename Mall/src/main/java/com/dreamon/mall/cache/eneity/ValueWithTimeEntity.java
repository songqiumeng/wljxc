package com.dreamon.mall.cache.eneity;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by qiumengsong on 2017/8/14.
 */
public class ValueWithTimeEntity extends ValueEntity {

    @Value("${cache.default.lasttime}")
    private long lastTime;
    private long deadTime;

    public ValueWithTimeEntity(Object content,long timestamp,long lastTime,long deadTime){
        super(content,timestamp);
    }

    public ValueWithTimeEntity(Object content,long lastTime){
        this(content,System.currentTimeMillis(), lastTime,-1);
    }

    public ValueWithTimeEntity(Object content) {
        super(content);
    }

}
