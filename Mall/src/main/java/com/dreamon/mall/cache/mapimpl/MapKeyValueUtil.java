package com.dreamon.mall.cache.mapimpl;

import com.dreamon.mall.cache.KeyValueUtil;
import com.dreamon.mall.cache.UserKeyValueUtil;
import com.dreamon.mall.cache.eneity.ValueEntity;
import com.dreamon.mall.exception.KeyValueException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by qiumengsong on 2017/8/14.
 */
@Component
class MapKeyValueUtil implements KeyValueUtil{

    @Resource(name = "keyvaluemap")
    private Map<Object,ValueEntity> map;

    public void addKeyValue(Object key, ValueEntity entity) throws KeyValueException {
        map.put(key,entity);
    }

    public void setKeyValue(Object key, ValueEntity entity) throws KeyValueException {
        map.put(key,entity);
    }

    public void deleteKeyValue(Object key) throws KeyValueException {
        map.remove(key);
    }

    public ValueEntity getKeyValue(Object key) throws KeyValueException {
        return map.get(key);
    }
}
