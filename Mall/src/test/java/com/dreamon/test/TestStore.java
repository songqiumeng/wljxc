package com.dreamon.test;

import com.dreamon.mall.db.dao.StoreDao;
import com.dreamon.mall.model.StoreModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 店铺模块测试类
 * Created by qiumengsong on 2017/8/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class TestStore {

    @Resource
    private StoreDao storeDao;

    @Test
    public void testAddNewStore() throws Exception{
        storeDao.addNewStore(476224964,"我的店铺","联系人暂无","123456789",1,
                0.0,0.0,"没有其他信息","好点");
    }

    @Resource
    private StoreModel storeModel;

    @Test
    public void testGet() throws Exception{
        System.out.println(storeModel.getStoreByUserId(123));
    }

}
