package com.dreamon.test;

import com.dreamon.mall.base.BaseDao;
import static org.junit.Assert.*;

import com.dreamon.mall.base.BaseEntity;
import com.dreamon.mall.base.BaseException;
import com.dreamon.mall.db.entity.Demo;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
        BaseEntity demo = new Demo(3,"admin","嘿嘿");
        try {
            baseDao.add(null);
        } catch (BaseException e){
            e.printStackTrace();
        }

        System.out.println(demo);
    }

}
