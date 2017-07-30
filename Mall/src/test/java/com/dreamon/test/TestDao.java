package com.dreamon.test;

import com.dreamon.mall.base.BaseDao;
import static org.junit.Assert.*;

import com.dreamon.mall.base.BaseEntity;
import com.dreamon.mall.base.BaseException;
import com.dreamon.mall.db.entity.Demo;
import com.dreamon.mall.db.entity.Userinfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qiumengsong on 2017/7/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class TestDao {

    @Resource
    private BaseDao baseDao;


    @Test
    public void testBaseGet(){
        assertNotNull(baseDao);
        BaseEntity demo = new Demo();
        demo.setId(1);
        demo = baseDao.get(demo);
        System.out.println(demo);
    }

    @Test
    public void testBaseAdd() {
//        BaseEntity demo = new Demo(3,"admin","嘿嘿");
        Userinfo userinfo = new Userinfo("heihei","123456");
        try {
            baseDao.add(userinfo);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private Userinfo userinfo;

    /**
     * 测试条件查询函数
     */
    @Test
    public void testGetAll(){
        userinfo = new Userinfo();
        userinfo.put("name","admin123");
        List<BaseEntity> queryResult = baseDao.getAll(userinfo,0,0);
        System.out.println(queryResult);
    }

    @Test
    public void testConnection(){
        baseDao.before();
    }

}
