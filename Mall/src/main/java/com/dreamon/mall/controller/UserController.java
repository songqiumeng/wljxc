package com.dreamon.mall.controller;

import com.dreamon.mall.base.BaseController;
import com.dreamon.mall.base.BaseResponse;
import com.dreamon.mall.exception.OutException;
import com.dreamon.mall.model.UserModel;
import com.dreamon.mall.service.IdCodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 用户相关的控制器
 * Created by qiumengsong on 2017/7/27.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Resource
    private UserModel userModel;
    @Resource
    private IdCodeService idCodeService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String tel,String pwd){
        if (tel ==null || tel.length() == 0||
                pwd == null || pwd.length() == 0
                )
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();
        try {
            userModel.login(tel,pwd);
        } catch (OutException e){
            e.printStackTrace();
            return new BaseResponse(e.errorCode,e.errorMessage).toJsonStr();
        }
        return new BaseResponse(OK,OK_STR).toJsonStr();
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public String register(String phoneNumber,String password,String idCode){
        //判断参数有效性
        if (phoneNumber == null || phoneNumber.length() == 0||
                password == null || password.length() == 0 ||
                idCode == null || idCode.length() == 0
                )
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();
        try {
            userModel.register(phoneNumber,password,idCode);
        } catch (OutException e){
            return new BaseResponse(e.errorCode,e.errorMessage).toJsonStr();
        }

        return new BaseResponse(OK,OK_STR).toJsonStr();
    }

    /**
     * 获取并发送验证码的接口
     * @param phoneNumber
     * @return
     */
    @RequestMapping(value = "/getregisteridcode")
    @ResponseBody
    public String getRegisterIdCode(String phoneNumber){
        if (phoneNumber == null || phoneNumber.length() == 0){
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();
        }
        //发送电话号码
        try {
            userModel.getRegisterIdCode(phoneNumber);
        } catch (OutException e){
            return new BaseResponse(e.errorCode,e.errorMessage).toJsonStr();
        }
        return new BaseResponse(OK,OK_STR).toJsonStr();
    }

    /**
     * 检验验证码是否有效
     * @param phoneNumber
     * @param idCode
     * @return
     */
    @RequestMapping(value = "/chechregisteridcode")
    @ResponseBody
    public String checkRegisterIdCode(String phoneNumber,String idCode){
        //验证参数
        if (phoneNumber == null || phoneNumber.length() == 0 ||
                idCode == null || idCode.length() == 0
                )
            return new BaseResponse(PARAM_EMPTY,PARAM_EMPTY_STR).toJsonStr();
        try {
            idCodeService.checkAndRefreshIdCode(phoneNumber, idCode);
        } catch (OutException e){
            return new BaseResponse(e.errorCode,e.errorMessage).toJsonStr();
        }
        return new BaseResponse(OK,OK_STR).toJsonStr();
    }

}
