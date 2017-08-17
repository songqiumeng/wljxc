package com.dreamon.mall.cache.mapimpl;

import com.dreamon.mall.cache.KeyValueWithTimeUtil;
import com.dreamon.mall.cache.TimeKeyValueUtil;
import com.dreamon.mall.cache.eneity.ValueEntity;
import com.dreamon.mall.exception.KeyValueException;

import java.util.List;

/**
 * Created by qiumengsong on 2017/8/14.
 */
public class MapKeyValueWithTimeUtil extends MapKeyValueUtil implements KeyValueWithTimeUtil,TimeKeyValueUtil {

    public List<ValueEntity> getValueByTime(long deadline) throws KeyValueException {
        return null;
    }

    public List<ValueEntity> getValueByTime(long startTime, long endTime) throws KeyValueException {
        return null;
    }

    public void deleteValueByTime(long deadline) throws KeyValueException {

    }

    public void deleteValueByTime(long startTime, long endTime) throws KeyValueException {

    }

    public void refreshValueByTime(long deadline, ValueEntity entity) throws KeyValueException {

    }

    public void refreshValueByTime(long start, long end, ValueEntity entity) throws KeyValueException {

    }
}
