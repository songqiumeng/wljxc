package com.dreamon.mall.base;

import org.codehaus.jackson.map.ObjectMapper;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiumengsong on 2017/7/27.
 */
public class BaseResponse {

    private int status;
    private String desc;
    private Map<String,Object> content;
    private long timestamp;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<String, Object> getContent() {
        return content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public BaseResponse(int status, String desc, Map<String, Object> content, long timestamp) {
        this.status = status;
        this.desc = desc;
        this.content = content;
        this.timestamp = timestamp;
    }

    public BaseResponse(int status, String desc, Map<String, Object> content) {
        this(status,desc,content,System.currentTimeMillis());
    }

    public BaseResponse(int status, String desc) {
        this(status,desc,null);
    }

    public BaseResponse(int status,String desc,String index,Object obj){
        this(status,desc);
        content = new HashMap<String, Object>();
        content.put(index,obj);
    }

    @Resource
    private ObjectMapper objectMapper;

    public String toJsonStr() {
        String result = "";
        try {
            result = objectMapper.writeValueAsString(this);
            System.out.println("JSON字符串生成成功");
        } catch (IOException e){
            e.printStackTrace();
            result = "";
        }
        return result;
    }

}
