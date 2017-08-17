package com.dreamon.mall.exception;

import com.dreamon.mall.base.BaseException;

/**
 * Created by qiumengsong on 2017/8/13.
 */
public class KeyValueException extends BaseException {

    public KeyValueException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
