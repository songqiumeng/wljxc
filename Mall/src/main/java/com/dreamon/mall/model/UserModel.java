package com.dreamon.mall.model;

import com.aliyuncs.exceptions.ClientException;
import com.dreamon.mall.base.BaseModel;
import com.dreamon.mall.exception.MessageException;
import com.dreamon.mall.exception.OutException;
import com.dreamon.mall.service.IdCodeService;
import com.dreamon.mall.service.MessageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by wmt on 2017/7/29.
 */
@Component
public class UserModel extends BaseModel {

    @Resource
    private IdCodeService idCodeService;

    @Resource
    private MessageService messageService;

    /**
     * 获取用户注册验证码
     * @param phoneNumber 用户电话号码
     */
    public void getRegisterIdCode(String phoneNumber) throws OutException{
        String idCode = idCodeService.instanceAndRegisterIdCode(phoneNumber);
        //发送验证码
        try {
            messageService.sendIdcodeMessage(phoneNumber,idCode,MessageService.MSG_REGISTER_MODEL);
        } catch (ClientException e){
            e.printStackTrace();
            throw new OutException(MSG_SEND_FAIL,MSG_SEND_FAIL_STR);
        } catch ( MessageException e){
            e.printStackTrace();
            throw new OutException(MSG_SEND_FAIL,MSG_SEND_FAIL_STR);
        }
    }

}
