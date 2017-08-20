package com.dreamon.test;

import com.dreamon.mall.db.dao.GoodTypeDao;
import com.dreamon.mall.model.GoodModel;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * Created by qiumengsong on 2017/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class TestGoodModel {

    @Resource
    private GoodModel goodModel;

    @Test
    public void testGetAll2(){
        System.out.println(goodModel.getAllType(0,0));
    }

    @Test
    public void testGetAll(){
        System.out.println(goodModel.getAllGood());
    }


    @Test
    public void testGetByUser(){
        System.out.println(goodModel.getGoodsByUserid(2));
    }

    @Test
    public void testAddGood() throws Exception{
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        goodModel.addGood("商品1 ",1,1,"123","123",
                1,1,"1234",1,1,"asdf","sfefef",
                "fwef","fwefwe","fwewef",timestamp,0.0);
    }

}
