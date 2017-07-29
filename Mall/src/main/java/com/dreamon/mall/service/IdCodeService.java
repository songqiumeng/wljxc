package com.dreamon.mall.service;

import com.dreamon.mall.base.Status;
import com.dreamon.mall.exception.OutException;
import com.dreamon.mall.service.entity.IdCode;
import com.sun.xml.internal.ws.api.server.WSEndpoint;

import java.util.HashMap;
import java.util.Random;

/**
 * 验证码服务
 * Created by wmt on 2017/7/29.
 */
public class IdCodeService implements Status {

    /**
     * 验证码长度
     */
    private final int idCodeLength;
    /**
     * 验证码类型
     */
    private final int idCodeType;
    /**
     * 验证码有效时间
     */
    private final long idCodeLastTime;

    public IdCodeService(long idCodeLastTime, int idCodeLength, int idCodeType) {
        this.idCodeLastTime = idCodeLastTime;
        this.idCodeLength = idCodeLength;
        this.idCodeType = idCodeType;
    }

    public static final int IDCODE_NUMBER_ONLY_MODEL = 0;
    public static final int IDCODE_MIXED_MODEL = 1;

    private static Random random = new Random();
    private static HashMap<String,IdCode> idCodeMap = new HashMap<String, IdCode>();

    /**
     * 实例化一个验证码
     * @return
     */
    public String instanceIdCode(){
        //TODO 混合模式验证码未实现
        int idCode = random.nextInt();
        //保证idCode原始值为正
        idCode = idCode < 0 ? -idCode : idCode;
        return (idCode + "").substring(0,idCodeLength);
    }

    /**
     * 注册一个验证码
     * @param idCode
     * @param phoneNumber
     */
    public void registerIdCode(String idCode,String phoneNumber){
        idCodeMap.put(phoneNumber,new IdCode(idCode,System.currentTimeMillis()));
    }

    /**
     * 生成并注册一个验证码
     * @param phoneNumber
     */
    public String instanceAndRegisterIdCode(String phoneNumber){
        String idCode = instanceIdCode();
        registerIdCode(idCode,phoneNumber);
        return idCode;
    }

    /**
     * 判断验证码是否合法
     * @param phoneNumber
     * @param idCode
     * @return
     */
    public boolean checkIdCode(String phoneNumber,String idCode){
        try {
            isIdCodeUseful(phoneNumber,idCode);
        } catch (OutException e){
            return false;
        }
        return true;
    }

    /**
     * @param phoneNumber
     * @param idCode
     */
    public void isIdCodeUseful(String phoneNumber,String idCode) throws OutException{
        IdCode valueCode = idCodeMap.get(phoneNumber);
        if (valueCode == null){
            //不存在验证码
            throw new OutException(ICS_PHONE_NOT_REGISTED,ICS_PHONE_NOT_REGISTED_STR);
        }
        String idCodeContent = valueCode.getContent();
        if (!idCodeContent.equals(idCode)){
            //验证码错误
            throw new OutException(ICS_WRONG_NUMBER,ICS_WRONG_NUMBER_STR);
        }
        long idCodeTime = valueCode.getTime();
        long currentTime = System.currentTimeMillis();
        if (idCodeTime + idCodeLastTime < currentTime) {
            //验证码超时
            throw new OutException(ICS_OUT_OF_TIME,ICS_OUT_OF_TIME_STR);
        }
    }


    //TODO 开启线程清除过期idcode

}
