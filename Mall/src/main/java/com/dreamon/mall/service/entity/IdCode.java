package com.dreamon.mall.service.entity;

/**
 * 验证码
 * Created by wmt on 2017/7/29.
 */
public class IdCode {

    /**
     * 验证码内容
     */
    private String content;
    /**
     * 生成时间
     */
    private long time;

    public IdCode(String content, long time) {
        this.content = content;
        this.time = time;
    }

    @Override
    public String toString() {
        return "IdCode{" +
                "content='" + content + '\'' +
                ", time=" + time +
                '}';
    }

    public String getContent() {
        return content;
    }

    public long getTime() {
        return time;
    }
}
