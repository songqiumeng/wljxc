package com.dreamon.mall.exception;

import com.dreamon.mall.base.BaseException;

/**
 * 需要通知管理员的异常
 * Created by wmt on 2017/7/30.
 */
public class InException extends BaseException{

    public InException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
