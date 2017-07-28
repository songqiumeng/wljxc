package com.dreamon.mall.base;

/**
 * Created by qiumengsong on 2017/7/27.
 */
public class BaseException extends Exception {
    public int errorCode;
    public String errorMessage;

    public BaseException(int errorCode,String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
