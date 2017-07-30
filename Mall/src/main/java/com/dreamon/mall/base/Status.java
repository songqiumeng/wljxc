package com.dreamon.mall.base;

/**
 * Created by qiumengsong on 2017/7/27.
 */
public interface Status {

    int OK = 0;
    String OK_STR = "OK";

    int IN_SAME_TELEPHONE = 100;
    String IN_SAME_TELEPHONE_STR = "电话号码被注册了两次";

    //注册状态
    int RS_TELEPHONE_REGISTERED = 200;
    String RS_TELEPHONE_REGISTERED_STR = "电话号码已经被注册";
    int RS_FAIL = 201;
    String RS_FAIL_STR = "注册失败";

    //登录状态
    int LG_USER_NOT_EXITED = 250;
    String LG_USER_NOT_EXITED_STR = "用户不存在";
    int LG_PASSWORD_WRONG = 251;
    String LG_PASSWORD_WRONG_STR = "密码错误";

    int PARAM_EMPTY = 400;
    String PARAM_EMPTY_STR = "参数不完整";

    //短信相关状态
    int MSG_SEND_FAIL = 500;
    String MSG_SEND_FAIL_STR = "验证码短信发送失败";
    int MSG_ILLAGEL_PHONE_NUMBER = 501;
    String MSG_ILLAGEL_PHONE_NUMBER_STR = "电话号码不合法";

    //验证码状态
    int ICS_PHONE_NOT_REGISTED = 550;
    String ICS_PHONE_NOT_REGISTED_STR= "手机未申请过验证码";
    int ICS_OUT_OF_TIME = 551;
    String ICS_OUT_OF_TIME_STR = "验证码过期";
    int ICS_WRONG_NUMBER = 552;
    String ICS_WRONG_NUMBER_STR = "验证码错误";
    int ICS_WRONG = 553;
    String ICS_WRONG_STR = "验证码检验失败";

    //数据库相关状态
    int DB_EMPTY_UPDATE_PARAM = 600;
    String DB_EMPTY_UPDATE_PARAM_STR = "更新数据时参数为空集合";

    int DB_ADD_FAIL = 601;
    String DB_ADD_FAIL_STR = "插入数据库时出现异常导致插入失败";

}
