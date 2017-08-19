package com.dreamon.mall.model;

import com.dreamon.mall.base.BaseEntity;
import com.dreamon.mall.base.Status;
import com.dreamon.mall.db.dao.StoreDao;
import com.dreamon.mall.db.entity.Store;
import com.dreamon.mall.exception.DaoException;
import com.dreamon.mall.exception.IllegalArguementException;
import com.dreamon.mall.exception.OutException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 店铺相关的业务
 * Created by qiumengsong on 2017/8/19.
 */
@Component
public class StoreModel implements Status {

    @Resource
    private StoreDao storeDao;

    /**
     * 新增一家店铺
     * @param userid
     * @param name
     * @param contact
     * @param phone
     * @param headImg
     * @param locationX
     * @param locationY
     * @param other
     * @param keyword
     * @return
     */
    public HashMap<String,String> addStore(int userid,String name,
                                           String contact,String phone,
                                           int headImg,double locationX,
                                           double locationY,String other,
                                           String keyword) throws OutException{
        try {
            storeDao.addNewStore(userid,name,contact,phone,headImg,locationX,locationY,other,keyword);
        } catch (DaoException e){
            e.printStackTrace();
            throw new OutException(STORE_ADD_FAIL,STORE_ADD_FAIL_STR);
        } catch (IllegalArguementException e){
            e.printStackTrace();
            throw new OutException(STORE_ADD_LACK_PARAM,STORE_ADD_LACK_PARAM_STR);
        }
        return null;
    }

    public HashMap<String,String> deleteStore(int userid,int storeId) throws OutException{
        //判断是否有权限
        //TODO 从缓存中获取userinfo，判断用户是否有权限

        //删除店铺
        try {
            storeDao.delete(storeId);
        } catch (IllegalArguementException e){
            e.printStackTrace();
            throw new OutException(STORE_DELETE_FAIL,STORE_DELETE_FAIL_STR);
        } catch (DaoException e){
            e.printStackTrace();
            throw new OutException(STORE_DELETE_FAIL,STORE_DELETE_FAIL_STR);
        }
        return null;
    }

    /**
     * 通过userid获取店铺
     * @param userId
     * @return
     * @throws OutException
     */
    public HashMap<String,Object> getStoreByUserId(int userId) throws OutException{
        Store store = new Store();
        store.put("userid",userId);
        List<BaseEntity> result = storeDao.getAll(store,0,0);
        HashMap<String,Object> returnMap = new HashMap<String, Object>();
        returnMap.put("content",result);
        return returnMap;
    }

}
