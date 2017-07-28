package com.dreamon.mall.base;

/**
 * Created by qiumengsong on 2017/7/27.
 */
public interface Status {

    int OK = 0;
    String OK_STR = "OK";

    int PARAM_EMPTY = 400;
    String PARAM_EMPTY_STR = "参数为null";

    //数据库相关状态
    int DB_EMPTY_UPDATE_PARAM = 600;
    String DB_EMPTY_UPDATE_PARAM_STR = "更新数据时参数为空集合";

    int DB_ADD_FAIL = 601;
    String DB_ADD_FAIL_STR = "插入数据库时出现异常导致插入失败";

}
