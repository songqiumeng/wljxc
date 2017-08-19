package com.dreamon.test;

import com.dreamon.mall.db.dao.GoodTypeDao;
import com.dreamon.mall.model.GoodModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by qiumengsong on 2017/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class TestGoodModel {

    @Resource
    private GoodModel goodModel;

    @Test
    public void testGetAll(){
        System.out.println(goodModel.getAll(0,0));
    }

}
