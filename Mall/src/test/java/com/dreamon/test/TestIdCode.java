package com.dreamon.test;

import com.dreamon.mall.service.IdCodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * 测试IdCodeService
 * Created by wmt on 2017/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class TestIdCode {

    @Resource
    private IdCodeService idCodeService;

    @Test
    public void testIdCodeInstant() throws Exception{
        assertNotNull(idCodeService);
        idCodeService.registerIdCode("1234","1561603");

        idCodeService.isIdCodeUseful("1561603","1234");
        Thread.sleep(1000);
        idCodeService.isIdCodeUseful("1561603","1234");

    }
}
