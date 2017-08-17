package com.dreamon.mall.cache.mapimpl;

import com.dreamon.mall.cache.UserKeyValueUtil;
import com.dreamon.mall.cache.eneity.UserValueEntity;
import com.dreamon.mall.exception.KeyValueException;

/**
 * Created by qiumengsong on 2017/8/16.
 */
public class MapUserKeyValueUtil extends MapKeyValueWithTimeUtil implements UserKeyValueUtil {

    public void addUserKeyValue(int number, UserValueEntity entity) throws KeyValueException {

    }

    public UserValueEntity getUserKeyValue(int number) throws KeyValueException {
        return null;
    }

    public void removeUserKeyValue(int number) throws KeyValueException {

    }

    public void updateUserKeyValue(int number, UserValueEntity newEntity) throws KeyValueException {

    }
}
