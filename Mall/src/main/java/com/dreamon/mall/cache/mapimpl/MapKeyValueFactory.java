package com.dreamon.mall.cache.mapimpl;

import com.dreamon.mall.cache.KeyValueUtil;
import com.dreamon.mall.cache.KeyValueWithTimeUtil;
import com.dreamon.mall.cache.TimeKeyValueUtil;
import com.dreamon.mall.cache.UserKeyValueUtil;
import com.dreamon.mall.cache.factory.KeyValueUtilFactory;
import com.dreamon.mall.cache.factory.UserKeyValueUtilFactory;
import com.dreamon.mall.exception.KeyValueException;

import javax.annotation.Resource;

/**
 * Created by qiumengsong on 2017/8/14.
 */
public class MapKeyValueFactory implements UserKeyValueUtilFactory,KeyValueUtilFactory {

    @Resource
    private MapKeyValueUtil mapKeyValueUtil ;

    public UserKeyValueUtil instanceUserKeyValueUtil() throws KeyValueException {
        return null;
    }

    public KeyValueUtil instanceKeyValueUtil() throws KeyValueException {
        return mapKeyValueUtil;
    }

    public KeyValueWithTimeUtil instanceKeyValueWithTimeUtil() throws KeyValueException {
        return null;
    }

    public TimeKeyValueUtil instanceTimeKeyValueUtil() throws KeyValueException {
        return null;
    }
}
