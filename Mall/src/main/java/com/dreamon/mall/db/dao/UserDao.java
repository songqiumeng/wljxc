package com.dreamon.mall.db.dao;

import com.dreamon.mall.base.BaseDao;
import com.dreamon.mall.base.BaseEntity;
import com.dreamon.mall.db.entity.Userinfo;
import com.dreamon.mall.exception.DaoException;
import com.dreamon.mall.exception.IllegalArguementException;
import com.dreamon.mall.exception.InException;
import com.dreamon.mall.exception.OutException;
import com.dreamon.mall.service.IdCodeService;
import com.dreamon.mall.service.NumberService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表逻辑处理类
 * Created by wmt on 2017/7/28.
 */
@Component
public class UserDao extends BaseDao {

    @Resource
    private IdCodeService idCodeService;
    @Resource
    private NumberService numberService;

    /**
     * 通过name和password添加一个用户
     * @param name
     * @param password
     * @throws IllegalArguementException
     * @throws DaoException 电话已经被注册
     */
    public void addUserWithNameAndPassword(String name,String password) throws IllegalArguementException,DaoException{
        Userinfo userinfo = new Userinfo(name,password);
        userinfo.setNumber(numberService.getNumber());
        add(userinfo);
    }

    /**
     * 通过userName获取用户信息
     * @param name
     * @return
     * @throws OutException
     */
    public Userinfo getUserByName(String name) throws OutException{
        Userinfo userinfo = new Userinfo();
        userinfo.put("name",name);
        List<BaseEntity> list = getAll(userinfo,0,0);
        if (list.size() == 1){
            return (Userinfo)list.get(0);
        } else {
            throw new OutException(LG_USER_NOT_EXITED,LG_USER_NOT_EXITED_STR);
        }
    }

}
