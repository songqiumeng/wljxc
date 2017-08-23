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
     * @throws IllegalArguementException 传入参数异常时，抛出
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

    /**
     * 通过id查询商品
     * @param userid
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<BaseEntity> getGoodByUserid(int userid,int pageIndex,int pageSize){
        Good good = new Good();
        good.put("userid",userid);

        return getAll(good,pageIndex,pageSize);
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
     * @throws IllegalArguementException 传入参数异常时，抛出
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
                                      int requestInt) throws IllegalArguementException {

        Good param=new Good();
        param.put("id",idInt);
        Good value=new Good();
        value.put("name",name);
        value.put("goodtype",goodtypeInt);
        value.put("store",storeInt);
        value.put("guige",guige);
        value.put("txm",txm);
        value.put("viewprice",viewpriceInt);
        value.put("inprice",inpriceInt);
        value.put("other",other);
        value.put("userid",useridInt);
        value.put("storeid",storeidInt);
        value.put("content",content);
        value.put("typelist",typelist);
        value.put("monthnumber",monthnumberInt);
        value.put("totalnumber",totalnumberInt);
        value.put("commentnumber",commentnumberInt);
        value.put("good",goodInt);
        value.put("meddile",meddileInt);
        value.put("bad",badInt);
        value.put("cpbh",cpbh);
        value.put("cpxlh",cpxlh);
        value.put("xsdw",xsdw);
/*这个参数存在特殊问题（关键字冲突，构造方法不同等等）*/
        value.put("package",pachage);
        value.put("color",color);
/*这个参数存在特殊问题（关键字冲突，构造方法不同等等）*/
        value.put("uptime",uptimeTim);
        value.put("lrl",lrlDou);
        value.put("aveprice",avepriceDou);
        value.put("comprice",compriceDou);
        value.put("instore",instoreInt);
        value.put("outstore",outstoreInt);
        value.put("request",requestInt);
        update(value,param);



    }

    /**
     *通过id来更改货物的各种库存信息
     * @param idInt
     * @param storeInt
     * @param storeidInt
     * @param instoreInt
     * @param outstoreInt
     * @throws IllegalArguementException
     */
    public void modifyGoodStorebyId(int idInt,int storeInt,int storeidInt,int instoreInt,int outstoreInt)throws IllegalArguementException {
        Good param=new Good();
        param.put("id",idInt);
        Good value=new Good();
        value.put("store",storeInt);
        value.put("storeid",storeidInt);
        value.put("instore",instoreInt);
        value.put("outstore",outstoreInt);
        update(value,param);
    }

    /**
     * 通过id来更改货物的各种价格信息
     * @param idInt
     * @param viewpriceInt
     * @param inpriceInt
     * @param avepriceDou
     * @param compriceDou
     * @throws IllegalArguementException 传入参数异常时，抛出
     */
    public void modifyGoodPricebyId(int idInt,int viewpriceInt,int inpriceInt,double avepriceDou,double compriceDou) throws IllegalArguementException {
        Good param=new Good();
        param.put("id",idInt);
        Good value=new Good();
        value.put("viewprice",viewpriceInt);
        value.put("inprice",inpriceInt);
        value.put("aveprice",avepriceDou);
        value.put("comprice",compriceDou);
        update(value,param);
    }

    /**
     * 通过id来修改除了number和name之外所有的货物信息
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
     * @throws IllegalArguementException 传入参数异常时，抛出
     */
    public void modifyGoodOtherInfobyId(int idInt,String name,int goodtypeInt,String guige,
                                        String txm,String other,int useridInt,String content,
                                        String typelist,int monthnumberInt,int totalnumberInt,
                                        int commentnumberInt,int goodInt,int meddileInt,
                                        int badInt,String cpbh,String cpxlh,String xsdw,
                                        String pachage,String color,Timestamp uptimeTim,
                                        double lrlDou,int requestInt) throws IllegalArguementException {
        Good param=new Good();
        param.put("id",idInt);
        Good value=new Good();
        value.put("name",name);
        value.put("goodtype",goodtypeInt);
        value.put("guige",guige);
        value.put("txm",txm);
        value.put("other",other);
        value.put("userid",useridInt);
        value.put("content",content);
        value.put("typelist",typelist);
        value.put("monthnumber",monthnumberInt);
        value.put("totalnumber",totalnumberInt);
        value.put("commentnumber",commentnumberInt);
        value.put("good",goodInt);
        value.put("meddile",meddileInt);
        value.put("bad",badInt);
        value.put("cpbh",cpbh);
        value.put("cpxlh",cpxlh);
        value.put("xsdw",xsdw);
        /*这个参数存在特殊问题（关键字冲突，构造方法不同等等）*/
        value.put("package",pachage);
        value.put("color",color);
        /*这个参数存在特殊问题（关键字冲突，构造方法不同等等）*/
        value.put("uptime",uptimeTim);
        value.put("lrl",lrlDou);
        value.put("request",requestInt);
        update(value,param);
    }
}
