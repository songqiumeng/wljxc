package com.dreamon.mall.controller;

import com.dreamon.mall.base.BaseController;
import com.dreamon.mall.base.BaseResponse;
import com.dreamon.mall.exception.OutException;
import com.dreamon.mall.model.StoreModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by qiumengsong on 2017/8/19.
 */
@Controller
@RequestMapping(value = "/store")
public class StoreController extends BaseController {

    @Resource
    private StoreModel storeModel;

    /**
     * 新增店铺
     * @return
     */
    @RequestMapping(value = "/addstore")
    @ResponseBody
    public String addStore(int userid,String name,
                           String contact,String phone,
                           int headImg,double locationX,
                           double locationY,String other,
                           String keyword){
        //判断参数
        if (userid == 0 ||
            name == null || name.length() == 0 ||
            contact == null || contact.length() == 0 ||
            phone == null || phone.length() == 0 ||
            headImg == 0 ||
            locationX == 0.0 || locationY == 0.0 ||
            other == null || other.length() == 0 ||
            keyword == null || keyword.length() == 0
                )
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();

        try {
            storeModel.addStore(userid, name, contact, phone, headImg, locationX, locationY, other, keyword);
            return new BaseResponse(OK,OK_STR).toJsonStr();
        } catch (OutException e){
            e.printStackTrace();
            return new BaseResponse(e.errorCode,e.errorMessage).toJsonStr();
        }
    }

    @RequestMapping(value = "/deletestore")
    @ResponseBody
    public String deleteStore(int userid,int storeId) {
        if (userid == 0 || storeId == 0){
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();
        }
        try {
            storeModel.deleteStore(userid, storeId);
            return new BaseResponse(OK,OK_STR).toJsonStr();
        } catch (OutException e){
            e.printStackTrace();
            return new BaseResponse(e.errorCode,e.errorMessage).toJsonStr();
        }
    }

    @RequestMapping(value = "/getstorebyuserid")
    @ResponseBody
    public String getStoreByUserId(int userId){
        if (userId == 0){
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();
        }
        try {
            HashMap<String,Object> result = storeModel.getStoreByUserId(userId);
            return new BaseResponse(OK,OK_STR,result).toJsonStr();
        } catch (OutException e){
            e.printStackTrace();
            return new BaseResponse(e.errorCode,e.errorMessage).toJsonStr();
        }
    }

}
