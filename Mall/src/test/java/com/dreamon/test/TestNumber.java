package com.dreamon.test;

import com.dreamon.mall.service.NumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by qiumengsong on 2017/8/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class TestNumber {

    @Resource
    private NumberService numberService;

    @Test
    public void testNumber(){
        System.out.println(numberService.getNumber(10));
    }

}
