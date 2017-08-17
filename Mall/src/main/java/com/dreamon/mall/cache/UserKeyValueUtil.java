package com.dreamon.mall.cache;

import com.dreamon.mall.cache.eneity.UserValueEntity;
import com.dreamon.mall.exception.KeyValueException;

/**
 * Created by qiumengsong on 2017/8/14.
 */
public interface UserKeyValueUtil extends TimeKeyValueUtil {

    void addUserKeyValue(int number, UserValueEntity entity) throws KeyValueException;
    UserValueEntity getUserKeyValue(int number) throws KeyValueException;
    void removeUserKeyValue(int number) throws KeyValueException;
    void updateUserKeyValue(int number,UserValueEntity newEntity) throws KeyValueException;

}
