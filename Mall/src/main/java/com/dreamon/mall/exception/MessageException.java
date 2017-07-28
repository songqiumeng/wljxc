package com.dreamon.mall.exception;

import com.dreamon.mall.base.BaseException;

/**
 * 发送短信相关异常
 * Created by wmt on 2017/7/28.
 */
public class MessageException extends BaseException{
    public MessageException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
