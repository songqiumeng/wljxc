package com.dreamon.mall.db.dao;

import com.dreamon.mall.base.BaseDao;
import com.dreamon.mall.db.entity.Store;
import com.dreamon.mall.exception.DaoException;
import com.dreamon.mall.exception.IllegalArguementException;
import org.springframework.stereotype.Component;

/**
 * Created by qiumengsong on 2017/8/19.
 */
@Component
public class StoreDao extends BaseDao {


    /**
     * 新增店铺
     * @param userNumber
     * @param name
     * @param contact
     * @param phone
     * @param headImg
     * @param locationX
     * @param locationY
     * @param other
     * @param keyword
     * @throws IllegalArguementException
     * @throws DaoException
     */
    public void addNewStore(int userNumber,String name,
                            String contact,String phone,
                            int headImg,double locationX,
                            double locationY,String other,
                            String keyword) throws IllegalArguementException,DaoException{
        Store store = new Store(1,userNumber,0,headImg,0,0,0,0,0,locationX,locationY,name,contact,phone,other,keyword);
        add(store);
    }

    /**
     * 删除一家店铺，逻辑删除
     * @param id
     * @throws DaoException
     * @throws IllegalArguementException
     */
    public void delete(int id) throws DaoException,IllegalArguementException{
        Store param = new Store();
        param.put("id",id);
        Store value = new Store();
        value.put("isdelete",1+"");
        update(value,param);
    }

}
