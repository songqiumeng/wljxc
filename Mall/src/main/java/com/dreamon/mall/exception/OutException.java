package com.dreamon.mall.exception;

import com.dreamon.mall.base.BaseException;

/**
 * 用户接触异常，异常状态可以直接返回给用户
 * Created by qiumengsong on 2017/7/27.
 */
public class OutException extends BaseException {

    public OutException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
