package com.dreamon.mall.cache;

import com.dreamon.mall.cache.eneity.ValueEntity;
import com.dreamon.mall.exception.KeyValueException;

import java.util.List;

/**
 * 根据时间的键值对缓存
 * Created by qiumengsong on 2017/8/14.
 */
public interface KeyValueWithTimeUtil extends KeyValueUtil {

    List<ValueEntity> getValueByTime(long deadline) throws KeyValueException;
    List<ValueEntity> getValueByTime(long startTime,long endTime ) throws KeyValueException;
    void deleteValueByTime(long deadline) throws KeyValueException;
    void deleteValueByTime(long startTime,long endTime ) throws KeyValueException;
    void refreshValueByTime(long deadline,ValueEntity entity) throws KeyValueException;
    void refreshValueByTime(long start,long end,ValueEntity entity) throws KeyValueException;

}
