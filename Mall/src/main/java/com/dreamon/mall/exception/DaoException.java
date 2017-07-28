package com.dreamon.mall.exception;

import com.dreamon.mall.base.BaseException;

/**
 * Created by qiumengsong on 2017/7/28.
 */
public class DaoException extends BaseException {

    public DaoException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
