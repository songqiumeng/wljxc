package com.dreamon.mall.cache.eneity;

import com.dreamon.mall.db.entity.Userinfo;

/**
 * Created by qiumengsong on 2017/8/14.
 */
public class UserValueEntity extends ValueWithTimeEntity {

    private Userinfo userinfo;

    /**
     * 最后请求时间
     */
    private long latestRequestTime;

    /**
     * 私钥 RSA加密
     */
    private String privateExponent;
    /**
     * 公钥 RSA加密
     */
    private String publicExponent;

    private String modulus;

    public String getModulus() {
        return modulus;
    }

    public void setModulus(String modulus) {
        this.modulus = modulus;
    }

    public UserValueEntity(Object content, long timestamp, long lastTime, long deadTime, Userinfo userinfo, long latestRequestTime, String privateExponent, String publicExponent, String modulus) {
        super(content, timestamp, lastTime, deadTime);
        this.userinfo = userinfo;
        this.latestRequestTime = latestRequestTime;
        this.privateExponent = privateExponent;
        this.publicExponent = publicExponent;
        this.modulus = modulus;
    }

    public UserValueEntity(Object content, long lastTime, Userinfo userinfo, long latestRequestTime, String privateExponent, String publicExponent, String modulus) {
        super(content, lastTime);
        this.userinfo = userinfo;
        this.latestRequestTime = latestRequestTime;
        this.privateExponent = privateExponent;
        this.publicExponent = publicExponent;
        this.modulus = modulus;
    }

    public UserValueEntity(Object content, Userinfo userinfo, long latestRequestTime, String privateExponent, String publicExponent, String modulus) {
        super(content);
        this.userinfo = userinfo;
        this.latestRequestTime = latestRequestTime;
        this.privateExponent = privateExponent;
        this.publicExponent = publicExponent;
        this.modulus = modulus;
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

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public long getLatestRequestTime() {
        return latestRequestTime;
    }

    public void setLatestRequestTime(long latestRequestTime) {
        this.latestRequestTime = latestRequestTime;
    }

    public String getPrivateExponent() {
        return privateExponent;
    }

    public void setPrivateExponent(String privateExponent) {
        this.privateExponent = privateExponent;
    }

    public String getPublicExponent() {
        return publicExponent;
    }

    public void setPublicExponent(String publicExponent) {
        this.publicExponent = publicExponent;
    }
}
