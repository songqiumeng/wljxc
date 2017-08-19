package com.dreamon.mall.cache.mapimpl;

import com.dreamon.mall.cache.UserKeyValueUtil;
import com.dreamon.mall.cache.eneity.UserValueEntity;
import com.dreamon.mall.exception.EncryptException;
import com.dreamon.mall.exception.KeyValueException;
import com.dreamon.mall.service.EncryptService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by qiumengsong on 2017/8/16.
 */
@Component
public class MapUserKeyValueUtil extends MapKeyValueWithTimeUtil implements UserKeyValueUtil {

    public static final int TOKEN_LENGTH = 32;

    @Resource
    private EncryptService encryptService ;

    public void addUserKeyValue(int number, UserValueEntity entity) throws KeyValueException {
        addKeyValue(number,entity);
    }

    public UserValueEntity getUserKeyValue(int number) throws KeyValueException {
        return (UserValueEntity)getKeyValue(number);
    }

    public void removeUserKeyValue(int number) throws KeyValueException {
        deleteKeyValue(number);
    }

    public void updateUserKeyValue(int number, UserValueEntity newEntity) throws KeyValueException {
        setKeyValue(number,newEntity);
    }

//    public boolean checkUserCacheExit(int number) throws KeyValueException {
//        Object obj = getKeyValue(number);
//        if (obj == null)
//            return false;
//        return true;
//    }
//
//    public boolean checkUserInfo(int number, String token) throws KeyValueException {
//        UserValueEntity entity = (UserValueEntity)getKeyValue(number);
//        //解析token
//        String modulus = entity.getModulus();
//        String privateKey = entity.getPrivateExponent();
//        HashMap<String,String> tokenResult = null;
//        try {
//            tokenResult = encryptService.requestDecrypt(token,modulus,privateKey,TOKEN_LENGTH);
//        } catch (EncryptException e){
//            e.printStackTrace();
//            throw new KeyValueException(e.errorCode,e.errorMessage);
//        }
//
//        return false;
//    }
//
//    public boolean updateUserInfo(int number, String token) throws KeyValueException {
//        return false;
//    }
}
