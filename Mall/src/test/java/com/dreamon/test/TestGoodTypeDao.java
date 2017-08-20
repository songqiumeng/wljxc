package com.dreamon.test;

import com.dreamon.mall.db.dao.GoodTypeDao;
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
public class TestGoodTypeDao {

    @Resource
    private GoodTypeDao goodTypeDao;

    @Test
    public void testAdd() throws Exception{
//        goodTypeDao.ad("生鲜",22);
        goodTypeDao.addType("海鲜",1,23);
    }

//    @Test
//    public void testChange() throws Exception{
//        goodTypeDao.changeTypeName(2,"生鲜哈哈");
//    }

}
