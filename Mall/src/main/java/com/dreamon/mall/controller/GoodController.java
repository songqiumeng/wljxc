package com.dreamon.mall.controller;

import com.dreamon.mall.base.BaseController;
import com.dreamon.mall.base.BaseResponse;
import com.dreamon.mall.exception.OutException;
import com.dreamon.mall.model.GoodModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by qiumengsong on 2017/8/20.
 */
@Controller
@RequestMapping(value = "/good")
public class GoodController extends BaseController {

    @Resource
    private GoodModel goodModel;

    @RequestMapping(value = "/addroottype")
    @ResponseBody
    public String addRootType(String name,String typeimg){
        if (name == null || name.length() == 0 ||
                typeimg == null || typeimg.length() == 0)
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();
        int typeimgInt = 0;
        try {
            typeimgInt = Integer.parseInt(typeimg);
        } catch (NumberFormatException e){
            e.printStackTrace();
            return new BaseResponse(PARAM_FORMAT_WRONG,PARAM_FORMAT_WRONG_STR).toJsonStr();
        }
        try {
            goodModel.addRootType(name,typeimgInt);
            return new BaseResponse(OK,OK_STR).toJsonStr();
        } catch (OutException e){
            e.printStackTrace();
            return new BaseResponse(e.errorCode,e.errorMessage).toJsonStr();
        }
    }

    @RequestMapping(value = "/addgoodtype")
    @ResponseBody
    public String addGoodType(String name,String parentid,String typeimg) {
        if (name == null || name.length() == 0 ||
                parentid == null || parentid.length() == 0||
                typeimg == null || typeimg.length() == 0
                )
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();
        int parentIdInt = 0;
        int typeimgInt = 0;
        try {
            parentIdInt = Integer.parseInt(parentid);
            typeimgInt = Integer.parseInt(typeimg);
        } catch (NumberFormatException e){
            e.printStackTrace();
            return new BaseResponse(PARAM_FORMAT_WRONG,PARAM_FORMAT_WRONG_STR).toJsonStr();
        }

        try {
            goodModel.addGoodType(name,parentIdInt,typeimgInt);
            return new BaseResponse(OK,OK_STR).toJsonStr();
        } catch (OutException e){
            e.printStackTrace();
            return new BaseResponse(e.errorCode,e.errorMessage).toJsonStr();
        }
    }

    @RequestMapping(value = "/getalltype")
    @ResponseBody
    public String getAllType(String pageIndex,String pageSize){
        if (pageIndex == null || pageIndex.length() == 0 ||
                pageSize == null || pageSize.length() == 0
                )
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();
        int pageIndexInt = 0;
        int pageSizeInt = 0;
        try {
            pageIndexInt = Integer.parseInt(pageIndex);
            pageSizeInt = Integer.parseInt(pageSize);
        } catch (NumberFormatException e){
            e.printStackTrace();
            return new BaseResponse(PARAM_FORMAT_WRONG,PARAM_FORMAT_WRONG_STR).toJsonStr();
        }

        HashMap result =  goodModel.getAllType(pageIndexInt,pageSizeInt);
        return new BaseResponse(OK,OK_STR,result).toJsonStr();
    }

    @RequestMapping(value = "/changetypename")
    @ResponseBody
    public String changeTypeName(String typeid,String name) {
        if (typeid == null || name.length() == 0 ||
                name == null || name.length() == 0
                )
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();

        int typeidInt = 0;
        try {
            typeidInt = Integer.parseInt(typeid);
        } catch (NumberFormatException e){
            e.printStackTrace();
            return new BaseResponse(PARAM_FORMAT_WRONG,PARAM_FORMAT_WRONG_STR).toJsonStr();
        }

        try {
            goodModel.changeTypeName(typeidInt,name);
            return new BaseResponse(OK,OK_STR).toJsonStr();
        } catch (OutException e){
            e.printStackTrace();
            return new BaseResponse(e.errorCode,e.errorMessage).toJsonStr();
        }

    }


    @RequestMapping(value = "/deletetype")
    @ResponseBody
    public String deleteType(String typeid){
        if (typeid == null || typeid.length() == 0)
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();
        int typeidInt = 0;
        try {
            typeidInt = Integer.parseInt(typeid);
        } catch (NumberFormatException e){
            e.printStackTrace();
            return new BaseResponse(PARAM_FORMAT_WRONG,PARAM_FORMAT_WRONG_STR).toJsonStr();
        }
        goodModel.deleteType(typeidInt);
        return new BaseResponse(OK,OK_STR).toJsonStr();
    }

    @RequestMapping(value = "/addgood")
    @ResponseBody
    public String addGood(String name,String goodtype,String store,String guige,String txm,
                          String viewPrice,String inPrice,String other,String userid,
                          String sotreid,String content,String typeList,
                          String cpbh,String pachage,String color,String uptime,
                          String lrl){
        //TODO
        return new BaseResponse(OK,OK_STR).toJsonStr();
    }

    @RequestMapping(value = "/deletegood")
    @ResponseBody
    public String deleteGood(String userid,String goodid) {
        //TODO
        return new BaseResponse(OK,OK_STR).toJsonStr();
    }

    @RequestMapping(value = "/getgoodbyuserid")
    @ResponseBody
    public String getGoodsByUserid(String userid) {
        //TODO
        return new BaseResponse(OK,OK_STR).toJsonStr();
    }

    @RequestMapping(value = "/getallgood")
    @ResponseBody
    public String getAllGood(){
        return new BaseResponse(OK,OK_STR,goodModel.getAllGood()).toJsonStr();
    }

}

