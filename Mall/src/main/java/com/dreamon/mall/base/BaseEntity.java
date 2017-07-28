package com.dreamon.mall.base;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by qiumengsong on 2017/7/26.
 */
public abstract class BaseEntity {

    //entity对象中包含的信息
    private Map<String,Object> message = new HashMap();

    protected static HashSet<String> column;

    public Map<String, Object> getMessage() {
        return message;
    }

//    public void setMessage(Map<String, Object> message) {
//        this.message = message;
//    }

    /**
     * 检查传入的index是否合法
     * @return
     */
    public abstract boolean checkIndex(String index);


    public void put(String index,String value){
        if (!checkIndex(index)){
            throw new IllegalArgumentException();
        }
        message.put(index,value);
    }

    public abstract int getId();
    public abstract void setId(int id);
}
