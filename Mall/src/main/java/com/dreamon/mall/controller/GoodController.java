package com.dreamon.mall.controller;

import com.dreamon.mall.base.BaseController;
import com.dreamon.mall.base.BaseResponse;
import com.dreamon.mall.exception.OutException;
import com.dreamon.mall.model.GoodModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
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
    public String addGood(String name, String goodtype, String store, String guige, String txm,
                          String viewPrice, String inPrice, String other, String userid,
                          String storeid, String content, String typeList,
                          String cpbh, String pachage, String color, String uptime,
                          String lrl) {
        if (name == null || name.length() == 0
                || goodtype == null || goodtype.length() == 0
                || store == null || store.length() == 0
                || guige == null || guige.length() == 0
                || txm == null || txm.length() == 0
                || viewPrice == null || viewPrice.length() == 0
                || inPrice == null || inPrice.length() == 0
                || other == null || other.length() == 0
                || userid == null || userid.length() == 0
                || storeid == null || storeid.length() == 0
                || content == null || content.length() == 0
                || typeList == null || typeList.length() == 0
                || cpbh == null || cpbh.length() == 0
                || pachage == null || pachage.length() == 0
                || color == null || color.length() == 0
                || uptime == null || uptime.length() == 0
                || lrl == null || lrl.length() == 0) {
            return new BaseResponse(PARAM_EMPTY, PARAM_EMPTY_STR).toJsonStr();
        }

        int goodtypeInt = 0;
        int storeInt = 0;
        int viewpriceInt = 0;
        int inpriceInt = 0;
        int useridInt = 0;
        int storeidInt = 0;
        double lrlDouble = 0.0;
        Timestamp timestamp = null;
        try {
            goodtypeInt = Integer.parseInt(goodtype);
            storeInt = Integer.parseInt(store);
            viewpriceInt = Integer.parseInt(viewPrice);
            inpriceInt = Integer.parseInt(inPrice);
            useridInt = Integer.parseInt(userid);
            storeidInt = Integer.parseInt(storeid);
            lrlDouble = Double.parseDouble(lrl);
            //这里是检查日期格式
            timestamp = Timestamp.valueOf(uptime);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new BaseResponse(PARAM_FORMAT_WRONG, PARAM_FORMAT_WRONG_STR).toJsonStr();
        }
        try {
            goodModel.addGood(name, goodtypeInt, storeidInt, guige, txm, viewpriceInt, inpriceInt,
                    other, useridInt, storeidInt, content, typeList, cpbh, pachage, color, timestamp, lrlDouble);
        } catch (OutException e) {
            e.printStackTrace();
            return new BaseResponse(e.errorCode, e.errorMessage).toJsonStr();
        }
        return new BaseResponse(OK, OK_STR).toJsonStr();
    }

    @RequestMapping(value = "/deletegood")
    @ResponseBody
    public String deleteGood(String userid, String goodid) {
        if (userid == null || userid.length() == 0
                || goodid == null || goodid.length() == 0) {
            return new BaseResponse(PARAM_EMPTY, PARAM_EMPTY_STR).toJsonStr();
        }
        int useridInt=0;
        int goodidInt=0;
        try {
            useridInt= Integer.parseInt(userid);
            goodidInt=Integer.parseInt(goodid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new BaseResponse(PARAM_FORMAT_WRONG, PARAM_FORMAT_WRONG_STR).toJsonStr();
        }

        try {
            goodModel.deleteGood(useridInt,goodidInt);
        } catch (OutException e) {
            e.printStackTrace();
            return new BaseResponse(e.errorCode, e.errorMessage).toJsonStr();
        }
        return new BaseResponse(OK, OK_STR).toJsonStr();
    }

    @RequestMapping(value = "/getgoodbyuserid")
    @ResponseBody
    public String getGoodsByUserid(String userid) {
        if (userid == null || userid.length() == 0) {
            return new BaseResponse(PARAM_EMPTY, PARAM_EMPTY_STR).toJsonStr();
        }
        int useridInt=0;
        try {
            useridInt= Integer.parseInt(userid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new BaseResponse(PARAM_FORMAT_WRONG, PARAM_FORMAT_WRONG_STR).toJsonStr();
        }
        //这里如果没有查询无果，，则返回的content内容为空
        goodModel.getGoodsByUserid(useridInt);
        //TODO
        return new BaseResponse(OK, OK_STR).toJsonStr();
    }


    @RequestMapping(value = "/getallgood")
    @ResponseBody
    public String getAllGood(){
        return new BaseResponse(OK,OK_STR,goodModel.getAllGood()).toJsonStr();
    }

}

