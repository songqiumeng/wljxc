package com.dreamon.mall.model;

import com.dreamon.mall.base.BaseEntity;
import com.dreamon.mall.base.BaseException;
import com.dreamon.mall.base.BaseModel;
import com.dreamon.mall.db.dao.GoodTypeDao;
import com.dreamon.mall.db.entity.GoodType;
import com.dreamon.mall.exception.DaoException;
import com.dreamon.mall.exception.IllegalArguementException;
import com.dreamon.mall.exception.OutException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qiumengsong on 2017/8/19.
 */
@Component
public class GoodModel extends BaseModel {

    @Resource
    private GoodTypeDao goodTypeDao;

    /**
     * 添加商品种类
     * @param name
     * @param typeimg
     * @throws DaoException
     * @throws IllegalArguementException
     */
    public void addRootType(String name,int typeimg) throws OutException {
        try {
            goodTypeDao.addType(name,0,typeimg);
        } catch (BaseException e){
            e.printStackTrace();
            throw new OutException(GOODTYPE_ADD_FAIL,GOODTYPE_ADD_FAIL_STR);
        }

    }

    public void addGoodType(String name,int parentid,int typeimg) throws OutException{
        try {
            goodTypeDao.addType(name, parentid, typeimg);
        } catch (BaseException e){
            e.printStackTrace();
            throw new OutException(GOODTYPE_ADD_FAIL,GOODTYPE_ADD_FAIL_STR);
        }
    }

    /**
     * 获取全部的类型
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public HashMap<String,Object> getAll(int pageIndex, int pageSize){
        List<BaseEntity> list = goodTypeDao.getAll(GoodType.class,pageIndex,pageSize);
        HashMap<String,Object> result = new HashMap<String, Object>();
        ArrayList<HashMap<String,String>> content = new ArrayList<HashMap<String, String>>();
        for (BaseEntity entity : list) {
            GoodType goodType = (GoodType)entity;
            HashMap<String,String> line = new HashMap<String, String>();
            line.put("id",goodType.getId()+"");
            line.put("name",goodType.getName());
            line.put("img",goodType.getTypeimg()+"");
            content.add(line);
        }
        result.put("content",content);
        return result;
    }

}
