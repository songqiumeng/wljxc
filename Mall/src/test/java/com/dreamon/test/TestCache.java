package com.dreamon.test;

import com.dreamon.mall.cache.KeyValueUtil;
import com.dreamon.mall.cache.eneity.UserValueEntity;
import com.dreamon.mall.cache.eneity.ValueEntity;
import com.dreamon.mall.cache.eneity.ValueWithTimeEntity;
import com.dreamon.mall.cache.factory.KeyValueUtilFactory;
import com.dreamon.mall.exception.KeyValueException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by qiumengsong on 2017/8/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class TestCache {

    @Resource(name = "keyvaluefactory")
    private KeyValueUtilFactory factory;

    @Test
    public void testNull(){
        assertNotNull(factory);
    }

    @Test
    public void add() throws KeyValueException{
        KeyValueUtil util = factory.instanceKeyValueUtil();
        assertNotNull(util);
        util.addKeyValue(1,new ValueEntity(null));
    }

    @Value("${jdbc.password}")
    String password ;

    @Test
    public void str(){
        assertNotNull(password);
        System.out.println(password);

    }



}
