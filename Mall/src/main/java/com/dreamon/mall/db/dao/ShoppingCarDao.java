package com.dreamon.mall.db.dao;

import com.dreamon.mall.base.BaseDao;
import com.dreamon.mall.db.entity.ShoppingCar;
import com.dreamon.mall.exception.DaoException;
import com.dreamon.mall.exception.IllegalArguementException;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ShoppingCarDao extends BaseDao{

    /**
     * 新增购物车
     * @param goodid
     * @param price
     * @param number
     * @param userid
     * @param viewprice
     * @param hastip
     * @param name
     * @param addtime
     * @throws IllegalArgumentException
     * @throws DaoException
     */

    public void addNewShoppingCar(int goodid, int price,
                                  int number, int userid,
                                  int viewprice, int hastip,
                                  String name, Timestamp addtime)throws IllegalArguementException,DaoException{
        ShoppingCar shoppingCar = new ShoppingCar(goodid,price,number,userid,viewprice,0,hastip,name,addtime);
        try{
            add(shoppingCar);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }

    }
}
