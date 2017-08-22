package com.dreamon.mall.controller;

import com.dreamon.mall.base.BaseController;
import com.dreamon.mall.base.BaseResponse;
import com.dreamon.mall.exception.OutException;
import com.dreamon.mall.model.ShoppingCarModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Controller
@RequestMapping(value = "/cart")
public class ShoppingCarController extends BaseController {

    @Resource
    private ShoppingCarModel shoppingCarModel;

    @RequestMapping(value = "/addshoppingcar")
    @ResponseBody
    public String addShoppingCar(String goodid, String price,
                                 String number, String userid,
                                 String viewprice, String hastip,
                                 String name, Timestamp addtime){
        //判断参数
        if(goodid == null || goodid.length() == 0 ||
           price == null || price.length() == 0 ||
           number == null || number.length() == 0 ||
           userid == null || userid.length() == 0 ||
           viewprice == null || viewprice.length() == 0 ||
           hastip == null || hastip.length() == 0 ||
           name == null || name.length() == 0 ){
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();
        }
        int goodidInt = 0;
        int priceInt = 0;
        int numberInt = 0;
        int useridInt = 0;
        int viewpriceInt = 0;
        int hastipInt = 0;

        try{
            goodidInt = Integer.parseInt(goodid);
            priceInt = Integer.parseInt(price);
            numberInt = Integer.parseInt(number);
            useridInt = Integer.parseInt(userid);
            viewpriceInt = Integer.parseInt(viewprice);
            hastipInt = Integer.parseInt(hastip);
        } catch (NumberFormatException e){
            e.printStackTrace();
            return new BaseResponse(PARAM_FORMAT_WRONG,PARAM_FORMAT_WRONG_STR).toJsonStr();
        }

        try {
            shoppingCarModel.addshoppingcar( goodidInt,  priceInt, numberInt,  useridInt, viewpriceInt,  hastipInt, name,  addtime);
            return new BaseResponse(OK,OK_STR).toJsonStr();
        } catch (OutException e){
            e.printStackTrace();
            return new BaseResponse(e.errorCode,e.errorMessage).toJsonStr();
        }
    }

}
