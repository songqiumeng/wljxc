package com.dreamon.test;

import com.dreamon.mall.cache.KeyValueUtil;
import com.dreamon.mall.cache.eneity.ValueEntity;
import com.dreamon.mall.cache.factory.KeyValueUtilFactory;
import com.dreamon.mall.exception.KeyValueException;
import com.dreamon.mall.service.utils.RSAUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

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

    @Test
    public void testRsa() throws Exception{
        long start = System.currentTimeMillis();
        HashMap<String, Object> map = RSAUtils.getKeys();
        //生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");

        //模
        String modulus = publicKey.getModulus().toString();
        //公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        //私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();
        //明文
        String ming = "123456789";
        //使用模和指数生成公钥和私钥
        RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
        RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus, private_exponent);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(public_exponent + "...." +modulus + "......" + private_exponent);
    }

}
