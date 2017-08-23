package com.dreamon.mall.model;

import com.dreamon.mall.base.BaseEntity;
import com.dreamon.mall.base.BaseException;
import com.dreamon.mall.base.BaseModel;
import com.dreamon.mall.db.dao.GoodDao;
import com.dreamon.mall.db.dao.GoodTypeDao;
import com.dreamon.mall.db.entity.Good;
import com.dreamon.mall.db.entity.GoodType;
import com.dreamon.mall.exception.DaoException;
import com.dreamon.mall.exception.IllegalArguementException;
import com.dreamon.mall.exception.OutException;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.sql.Timestamp;
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

    @Resource
    private GoodDao goodDao;

    /**
     * 添加商品种类
     * @param name
     * @param typeimg
     * @throws DaoException
     */
    public void addRootType(String name, int typeimg) throws OutException {
        try {
            goodTypeDao.addType(name, 0, typeimg);
        } catch (BaseException e) {
            e.printStackTrace();
            throw new OutException(GOODTYPE_ADD_FAIL, GOODTYPE_ADD_FAIL_STR);
        }

    }

    /**
     * 添加商品类型
     * @param name
     * @param parentid
     * @param typeimg
     * @throws OutException
     */
    public void addGoodType(String name, int parentid, int typeimg) throws OutException {
        try {
            goodTypeDao.addType(name, parentid, typeimg);
        } catch (BaseException e) {
            e.printStackTrace();
            throw new OutException(GOODTYPE_ADD_FAIL, GOODTYPE_ADD_FAIL_STR);
        }
    }

    /**
     * 获取全部的类型
     *
     * @param pageIndex
     * @param pageSize
     * @return 种类的哈希表
     */
    public HashMap<String, Object> getAllType(int pageIndex, int pageSize) {
        List<BaseEntity> list = goodTypeDao.getAll(GoodType.class, pageIndex, pageSize);
        HashMap<String, Object> result = new HashMap<String, Object>();
        ArrayList<HashMap<String, String>> content = new ArrayList<HashMap<String, String>>();
        for (BaseEntity entity : list) {
            GoodType goodType = (GoodType) entity;
            HashMap<String, String> line = new HashMap<String, String>();
            line.put("id", goodType.getId() + "");
            line.put("name", goodType.getName());
            line.put("img", goodType.getTypeimg() + "");
            content.add(line);
        }
        result.put("content", content);
        return result;
    }

    /**
     * 更改类型名称
     * @param typeid
     * @param name
     */
    public void changeTypeName(int typeid, String name) throws OutException {
        GoodType value = new GoodType();
        GoodType param = new GoodType();

        value.put("name", name);
        param.put("id", typeid);

        try {
            goodTypeDao.update(value, param);
        } catch (IllegalArguementException e) {
            e.printStackTrace();
            throw new OutException(GOODTYPE_NAME_UPDATE_FAIL, GOODTYPE_NAME_UPDATE_FAIL_STR);
        }

    }

    /**
     * 删除商品种类
     * @param typeid
     */
    public void deleteType(int typeid) {
        GoodType goodType = new GoodType();
        goodType.setId(typeid);
        goodTypeDao.delete(goodType);
    }


    /**
     * 添加一个商品
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
     * @throws OutException
     */
    public void addGood(String name, int goodtype, int store, String guige, String txm,
                        int viewPrice, int inPrice, String other, int userid,
                        int sotreid, String content, String typeList,
                        String cpbh, String pachage, String color, Timestamp uptime,
                        double lrl) throws OutException {
        try {
            goodDao.addGood(name, goodtype, store, guige, txm, viewPrice, inPrice, other, userid, sotreid, content, typeList, cpbh, pachage, color, uptime, lrl);
        } catch (BaseException e) {
            e.printStackTrace();
            throw new OutException(GOOD_ADD_FAIL, GOOD_ADD_FAIL_STR);
        }
    }

    /**
     * 删除商品
     * @param userid
     * @param goodid
     * @throws OutException
     */
    public void deleteGood(int userid, int goodid) throws OutException {
        try {
            goodDao.deleteGood(goodid, userid);
        } catch (BaseException e) {
            e.printStackTrace();
            throw new OutException(GOOD_DELETE_FAIL, GOOD_DELETE_FAIL_STR);
        }
    }

    /**
     * 获得所有商品
     * @return 商品的哈希表
     */
    public HashMap<String, Object> getAllGood() {
        List<BaseEntity> goods = goodDao.getAll(Good.class, 0, 0);
        List<HashMap<String, String>> content = new ArrayList<HashMap<String, String>>();
        for (BaseEntity entity :
                goods) {
            Good good = (Good) entity;
            content.add(good.toHashMap());
        }
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("content", content);
        return result;
    }

    /**
     * 通过id查询商品
     * @param userid
     * @return
     */
    public HashMap<String, Object> getGoodsByUserid(int userid) {
        Good good = new Good();
        good.put("userid", userid);
        List<BaseEntity> goods = goodDao.getAll(good, 0, 0);
        //转换成json
        List<HashMap<String, String>> content = new ArrayList<HashMap<String, String>>();
        for (BaseEntity entity :
                goods) {
            good = (Good) entity;
            content.add(good.toHashMap());
        }
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("content", content);
        return result;
    }

    /**
     * 通过id来更改货物的所有信息
     * @param idInt
     * @param name
     * @param goodtypeInt
     * @param storeInt
     * @param guige
     * @param txm
     * @param viewpriceInt
     * @param inpriceInt
     * @param other
     * @param useridInt
     * @param storeidInt
     * @param content
     * @param typelist
     * @param monthnumberInt
     * @param totalnumberInt
     * @param commentnumberInt
     * @param goodInt
     * @param meddileInt
     * @param badInt
     * @param cpbh
     * @param cpxlh
     * @param xsdw
     * @param pachage
     * @param color
     * @param uptimeTim
     * @param lrlDou
     * @param avepriceDou
     * @param compriceDou
     * @param instoreInt
     * @param outstoreInt
     * @param requestInt
     * @throws OutException
     */
    public void modifyGoodAllInfobyId(int idInt,String name,int goodtypeInt,
                                      int storeInt,String guige,String txm,
                                      int viewpriceInt,int inpriceInt,String other,
                                      int useridInt,int storeidInt,String content,
                                      String typelist,int monthnumberInt,int totalnumberInt,
                                      int commentnumberInt,int goodInt,int meddileInt,
                                      int badInt,String cpbh,String cpxlh,
                                      String xsdw,String pachage,String color,
                                      Timestamp uptimeTim,double lrlDou,double avepriceDou,
                                      double compriceDou,int instoreInt,int outstoreInt,
                                      int requestInt) throws OutException {
        try {
            goodDao.modifyGoodAllInfobyId(idInt,name,goodtypeInt,
                    storeInt,guige,txm,
                    viewpriceInt,inpriceInt,other,
                    useridInt,storeidInt,content,
                    typelist,monthnumberInt,totalnumberInt,
                    commentnumberInt,goodInt,meddileInt,
                    badInt,cpbh,cpxlh,
                    xsdw,pachage,color,
                    uptimeTim,lrlDou,avepriceDou,
                    compriceDou,instoreInt,outstoreInt,
                    requestInt);
        } catch (IllegalArguementException e) {
            e.printStackTrace();
            throw new OutException(GOOD_UPDATA_FAIL,GOOD_UPDATA_FAIL_STR);
        }
    }


    /**
     * 通过id来更改货物的各种库存信息
     * @param idInt
     * @param storeInt
     * @param storeidInt
     * @param instoreInt
     * @param outstoreInt
     * @throws OutException
     */
    public void modifyGoodStorebyId(int idInt,int storeInt,int storeidInt,int instoreInt,int outstoreInt)throws OutException{
        try {
            goodDao.modifyGoodStorebyId(idInt,storeInt,storeidInt,instoreInt,outstoreInt);
        } catch (IllegalArguementException e) {
            e.printStackTrace();
            throw new OutException(GOOD_UPDATA_FAIL,GOOD_UPDATA_FAIL_STR);
        }
    }

    /**
     * 通过id来更改货物的各种价格信息
     * @param idInt
     * @param viewpriceInt
     * @param inpriceInt
     * @param avepriceDou
     * @param compriceDou
     * @throws OutException
     */
    public void modifyGoodPricebyId(int idInt,int viewpriceInt,int inpriceInt,double avepriceDou,double compriceDou) throws OutException{
        try {
            goodDao.modifyGoodPricebyId(idInt,viewpriceInt,inpriceInt,avepriceDou,compriceDou);
        } catch (IllegalArguementException e) {
            e.printStackTrace();
            throw new OutException(GOOD_UPDATA_FAIL,GOOD_UPDATA_FAIL_STR);
        }
    }
    /**
     * 通过id来修改除了价格和库存之外其他的货物信息
     * @param idInt
     * @param name
     * @param goodtypeInt
     * @param guige
     * @param txm
     * @param other
     * @param useridInt
     * @param content
     * @param typelist
     * @param monthnumberInt
     * @param totalnumberInt
     * @param commentnumberInt
     * @param goodInt
     * @param meddileInt
     * @param badInt
     * @param cpbh
     * @param cpxlh
     * @param xsdw
     * @param pachage
     * @param color
     * @param uptimeTim
     * @param lrlDou
     * @param requestInt
     * @throws OutException
     */
    public void modifyGoodOtherInfobyId(int idInt,String name,int goodtypeInt,String guige,
                                        String txm,String other,int useridInt,String content,
                                        String typelist,int monthnumberInt,int totalnumberInt,int commentnumberInt,int goodInt,int meddileInt,int badInt,String cpbh,String cpxlh,String xsdw,String pachage,String color,Timestamp uptimeTim,double lrlDou,int requestInt) throws OutException {
        try {
            goodDao.modifyGoodOtherInfobyId(idInt,name,goodtypeInt,guige,txm,other,useridInt,content,typelist,monthnumberInt,totalnumberInt,commentnumberInt,goodInt,meddileInt,badInt,cpbh,cpxlh,xsdw,pachage,color,uptimeTim,lrlDou,requestInt);
        } catch (IllegalArguementException e) {
            e.printStackTrace();
            throw new OutException(GOOD_UPDATA_FAIL,GOOD_UPDATA_FAIL_STR);
        }
    }
}