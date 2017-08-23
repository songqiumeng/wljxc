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
    int LG_SERVICE_FAIL = 252;
    String LG_SERVICE_FAIL_STR = "登陆服务出现异常";

    //用户状态
    int USER_MODIFY_FAIL=300;
    String USER_MODIFY_FAIL_STR="修改用户信息失败";

    //参数状态
    int PARAM_EMPTY = 400;
    String PARAM_EMPTY_STR = "参数不完整";

    int PARAM_FORMAT_WRONG = 401;
    String PARAM_FORMAT_WRONG_STR = "参数格式错误";

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

    //安全相关的问题
    int SAFE_DES_EXCP = 700;
    String SAFE_DES_EXCP_STR = "登陆解密是DES算法异常";

    int SAFE_NO_SUCH_ALGORITHM = 701;
    String SAFE_NO_SUCH_ALGORITHM_STR = "NoSuchAlgorithmException";

    int SAFE_RSA_DECRYPT_FAIL = 702;
    String SAFE_RSA_DECRYPT_FAIL_STR = "RSA解密时出现异常";

    //店铺相关状态
    int STORE_ADD_FAIL = 750;
    String STORE_ADD_FAIL_STR = "店铺添加失败,失败原因未知";

    int STORE_ADD_LACK_PARAM = 751;
    String STORE_ADD_LACK_PARAM_STR = "店铺添加失败，失败原因：参数错误";

    int STORE_DELETE_FAIL = 752;
    String STORE_DELETE_FAIL_STR = "店铺删除失败";

    //商品相关的状态码
    int GOODTYPE_PARENT_NOT_EXITED = 800;
    String GOODTYPE_PARENT_NOT_EXITED_STR = "父类型不存在";

    int GOODTYPE_ADD_FAIL = 801;
    String GOODTYPE_ADD_FAIL_STR = "添加商品失败";

    int GOODTYPE_NAME_UPDATE_FAIL = 802;
    String GOODTYPE_NAME_UPDATE_FAIL_STR = "种类名字更改失败";

    int GOOD_ADD_FAIL = 803;
    String  GOOD_ADD_FAIL_STR = "商品添加失败";

    int GOOD_DELETE_FAIL = 804;
    String  GOOD_DELETE_FAIL_STR = "商品删除失败";

    int GOOD_UPDATA_FAIL=805;
    String GOOD_UPDATA_FAIL_STR="更改商品信息失败";


    //购物车相关的状态码
    int SHOPPINGCAR_ADD_FAIL = 855;
    String SHOPPING_ADD_FAIL_STR = "添加购物车失败";

    int SHOPPINGCAR_ADD_LACK_PARAM = 856;
    String SHOPPINGCAR_ADD_LACK_PARAM_STR = "添加购物车失败，失败原因：参数错误";



}
