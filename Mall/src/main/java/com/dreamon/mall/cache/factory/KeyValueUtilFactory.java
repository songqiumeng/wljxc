package com.dreamon.mall.cache.factory;

import com.dreamon.mall.cache.KeyValueUtil;
import com.dreamon.mall.cache.KeyValueWithTimeUtil;
import com.dreamon.mall.cache.TimeKeyValueUtil;
import com.dreamon.mall.exception.KeyValueException;

/**
 * Created by qiumengsong on 2017/8/13.
 */
public interface KeyValueUtilFactory {

    KeyValueUtil instanceKeyValueUtil() throws KeyValueException;
    KeyValueWithTimeUtil instanceKeyValueWithTimeUtil() throws KeyValueException;
    TimeKeyValueUtil instanceTimeKeyValueUtil() throws KeyValueException;

}
