package com.dreamon.mall.cache;

import com.dreamon.mall.cache.eneity.ValueEntity;
import com.dreamon.mall.exception.KeyValueException;

/**
 * 键值对工具
 * Created by qiumengsong on 2017/8/13.
 */
public interface KeyValueUtil {

    void addKeyValue(Object key, ValueEntity entity) throws KeyValueException;
    void setKeyValue(Object key, ValueEntity entity) throws KeyValueException;
    void deleteKeyValue(Object key) throws KeyValueException;
    ValueEntity getKeyValue(Object key) throws KeyValueException;

}
