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

    /**
     * 修改用户信息
     * @param idInt
     * @param headimgInt
     * @param nickname
     * @param address
     * @param telephone
     * @param password
     * @throws IllegalArguementException
     */
    public void modifyUserInfobyId(int idInt,int headimgInt, String nickname, String address, String telephone, String password) throws IllegalArguementException{
        Userinfo value = new Userinfo();
        value.put("headimgInt",headimgInt);
        value.put("nickname",nickname);
        value.put("address",address);
        value.put("phone",telephone);
        value.put("password",password);

        Userinfo param=new Userinfo();
        param.put("id",idInt);
        //param是搜索条件，value是修改的后的内容
        update(value,param);
    }

}
