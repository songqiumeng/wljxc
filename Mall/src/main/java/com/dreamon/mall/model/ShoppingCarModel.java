package com.dreamon.mall.model;

import com.dreamon.mall.base.BaseModel;
import com.dreamon.mall.db.dao.ShoppingCarDao;
import com.dreamon.mall.exception.DaoException;
import com.dreamon.mall.exception.IllegalArguementException;
import com.dreamon.mall.exception.OutException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;

@Component
public class ShoppingCarModel extends BaseModel{

    @Resource
    private ShoppingCarDao shoppingCarDao;

    /**
     *
     * @param goodid
     * @param price
     * @param number
     * @param userid
     * @param viewprice
     * @param hastip
     * @param name
     * @param addtime
     * @return
     * @throws OutException
     */
    public HashMap<String,String> addshoppingcar(int goodid, int price,
                                                 int number, int userid,
                                                 int viewprice, int hastip,
                                                 String name, Timestamp addtime) throws OutException {
        //TODO 判断购物车里是否有该商品
        try {
            shoppingCarDao.addNewShoppingCar( goodid,  price, number,  userid, viewprice,  hastip, name,  addtime);
        }catch (DaoException e){
            e.printStackTrace();
            throw new OutException(SHOPPINGCAR_ADD_FAIL,SHOPPING_ADD_FAIL_STR);
        }catch (IllegalArguementException e){
            e.printStackTrace();
            throw new OutException(SHOPPINGCAR_ADD_FAIL,SHOPPING_ADD_FAIL_STR);
        }
        return null;
    }
}
