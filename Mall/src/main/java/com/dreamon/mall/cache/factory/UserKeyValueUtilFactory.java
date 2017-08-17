package com.dreamon.mall.cache.factory;

import com.dreamon.mall.cache.UserKeyValueUtil;
import com.dreamon.mall.exception.KeyValueException;

/**
 * Created by qiumengsong on 2017/8/14.
 */
public interface UserKeyValueUtilFactory{

    UserKeyValueUtil instanceUserKeyValueUtil() throws KeyValueException;

}
