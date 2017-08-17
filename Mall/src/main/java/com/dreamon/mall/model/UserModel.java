package com.dreamon.mall.model;

import com.aliyuncs.exceptions.ClientException;
import com.dreamon.mall.base.BaseModel;
import com.dreamon.mall.base.BaseResponse;
import com.dreamon.mall.db.dao.UserDao;
import com.dreamon.mall.db.entity.Userinfo;
import com.dreamon.mall.exception.DaoException;
import com.dreamon.mall.exception.IllegalArguementException;
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

    @Resource
    private UserDao userDao;

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

    public void register(String phoneNumber,String password,String idCode) throws OutException{
        //检验验证码有效性
        boolean isIdCodeUseful = idCodeService.checkAndDestoryIdCode(phoneNumber, idCode);
        if (!isIdCodeUseful) {
            //验证码不存在
            throw new OutException(ICS_WRONG,ICS_WRONG_STR);
        }
        try {
            userDao.addUserWithNameAndPassword(phoneNumber,password);
        } catch (IllegalArguementException e){
            e.printStackTrace();
            throw new OutException(RS_FAIL,RS_FAIL_STR);
        } catch (DaoException e){
            e.printStackTrace();
            //电话号码被注册过
            throw new OutException(RS_TELEPHONE_REGISTERED,RS_TELEPHONE_REGISTERED_STR);
        }
        System.out.println("注册成功");
    }

    /**
     * 用户登录
     * @param name
     * @param password
     * @return 用户编号
     * @throws OutException
     */
    public int login(String name,String password) throws OutException{
        Userinfo userinfo = userDao.getUserByName(name);
        String inPwd = userinfo.getPassword();
        if (inPwd != null && inPwd.equals(password)){
            return userinfo.getNumber();
        } else {
            throw new OutException(LG_PASSWORD_WRONG,LG_PASSWORD_WRONG_STR);
        }
    }

}
