package com.dreamon.mall.exception;

import com.dreamon.mall.base.BaseException;

/**
 * 参数异常
 * Created by qiumengsong on 2017/7/27.
 */
public class IllegalArguementException extends BaseException {

    public IllegalArguementException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
