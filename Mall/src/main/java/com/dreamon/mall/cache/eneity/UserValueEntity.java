package com.dreamon.mall.cache.eneity;

import com.dreamon.mall.db.entity.Userinfo;

/**
 * Created by qiumengsong on 2017/8/14.
 */
public class UserValueEntity extends ValueWithTimeEntity {

    private Userinfo userinfo;

    public UserValueEntity(Userinfo content, long lastTime) {
        super(content, lastTime);
        this.userinfo = content;
    }

    public UserValueEntity(Userinfo content){
        super(content);
        this.userinfo = content;
    }

    public String getName(){
        return userinfo.getName();
    }

    public int getLevel(){
        return userinfo.getType();
    }

    public int getState(){
        return userinfo.getState();
    }

    public String getPhone(){
        return userinfo.getPhone();
    }

}
