package com.dreamon.mall.exception;

import com.dreamon.mall.base.BaseException;

/**
 * Created by qiumengsong on 2017/8/17.
 */
public class EncryptException extends BaseException{

    public EncryptException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
