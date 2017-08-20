package com.dreamon.mall.db.dao;

import com.dreamon.mall.base.BaseDao;
import com.dreamon.mall.base.BaseEntity;
import com.dreamon.mall.db.entity.Good;
import com.dreamon.mall.exception.DaoException;
import com.dreamon.mall.exception.IllegalArguementException;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by qiumengsong on 2017/8/19.
 */
@Component
public class GoodDao extends BaseDao {

    /**
     * 新增商品
     * @param name
     * @param goodtype
     * @param store
     * @param guige
     * @param txm
     * @param viewPrice
     * @param inPrice
     * @param other
     * @param userid
     * @param sotreid
     * @param content
     * @param typeList
     * @param cpbh
     * @param pachage
     * @param color
     * @param uptime
     * @param lrl
     * @throws DaoException
     * @throws IllegalArguementException
     */
    public void addGood(String name,int goodtype,int store,String guige,String txm,
            int viewPrice,int inPrice,String other,int userid,
                        int sotreid,String content,String typeList,
                        String cpbh,String pachage,String color,Timestamp uptime,
                        double lrl) throws DaoException,IllegalArguementException
    {
        Good good = new Good(1,goodtype,store,viewPrice,inPrice,userid,sotreid,0,0,0,0,0,0,0,0,0,0.0,0.0,
                lrl,name,guige,txm,content,typeList,cpbh,"","",pachage,uptime);
        add(good);
    }

    /**
     * 删除商品
     * @param goodid
     */
    public void deleteGood(int goodid,int userid) throws IllegalArguementException,DaoException{
        Good value = new Good();
        value.put("isdelete",1);
        Good param = new Good();
        param.put("id",goodid);
        param.put("userid",userid);

        update(value,param);
    }

    public List<BaseEntity> getGoodByUserid(int userid,int pageIndex,int pageSize){
        Good good = new Good();
        good.put("userid",userid);

        return getAll(good,pageIndex,pageSize);
    }

}
