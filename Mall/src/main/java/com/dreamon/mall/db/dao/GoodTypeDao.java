package com.dreamon.mall.db.dao;

import com.dreamon.mall.base.BaseDao;
import com.dreamon.mall.db.entity.GoodType;
import com.dreamon.mall.exception.DaoException;
import com.dreamon.mall.exception.IllegalArguementException;
import org.springframework.stereotype.Component;


/**
 * Created by qiumengsong on 2017/8/19.
 */
@Component
public class GoodTypeDao extends BaseDao{

    public void addType(String name,int parentid,int typeimg) throws DaoException,IllegalArguementException{
        int level = 0;
        if (parentid != 0){
            //先获取父类级别
            GoodType goodType = new GoodType();
            goodType.setId(parentid);
            GoodType parent = (GoodType)get(goodType);
            if (parent == null) //父类型不存在
                throw new DaoException(GOODTYPE_PARENT_NOT_EXITED,GOODTYPE_PARENT_NOT_EXITED_STR);
            level = parent.getLevel() + 1;
        }
        GoodType goodType = new GoodType(name,0,level,parentid,typeimg);
        add(goodType);
    }

}
