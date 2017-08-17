package com.dreamon.mall.cache.eneity;

/**
 * Created by qiumengsong on 2017/8/13.
 */
public class ValueEntity {

    private Object content;
    private long timestamp;

    public ValueEntity(Object content, long timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public ValueEntity(Object content){
        this(content,System.currentTimeMillis());
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ValueEntity{" +
                "content=" + content +
                ", timestamp=" + timestamp +
                '}';
    }
}
