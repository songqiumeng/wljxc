package com.dreamon.test;

import com.dreamon.mall.exception.EncryptException;
import com.dreamon.mall.service.EncryptService;
import com.dreamon.mall.service.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by qiumengsong on 2017/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class TestEncrypt {

    @Test
    public void testMd5() throws Exception{
//        for (int i=0 ;i<10;i++)
         System.out.println(MD5Utils.md5("123456"));
    }

    @Resource
    private EncryptService service ;

    @Test
    public void testService() throws Exception{
        service.loginEncrypt("123456");
//        System.out.println(service.loginDecrypt("9X2z0+t+9YNUSNcQq51SnXl61o4GlsBcQcuo15WSFPI="));
    }

    @Test
    public void testKeys() throws Exception{
        System.out.println(service.getLoginKeys());
    }

    @Value("${safe.requesttoken}")
    private String innerToken;

    @Test
    public void testRSA() throws Exception{
        service.requestEncrypt("123456789",innerToken);
    }

    @Test
    public void testTSAEncrpty() throws Exception{
        HashMap map = service.requestDecrypt("1040E2683633638795ABD98E4F748A856569EAFF615B052814F72531393A6D25D9E632E41810C4C76181A4A6D35B2A7CFD78CB5607D4355D2F8E859DE35FB5E2595B1DC1E789C32A2A2F540304B124FF8DAB8A61114C53A69FE3241A715E1CA6B9989B296531BFC76D714142C62AD1B8362132948A172E6671FA367A3EBB3C13",
                "109508492818073068673713283879879637452459089067378487386036564796115729466678486205655437454374620076337245092257019144673363392550719896234139904688462721495528024948084963183154923535080274081582789068191854163893031474603625570559711998951860425903268936620861264437886426977844707814206865409273175438377",
                "84392571192907798746274060693000915043012325135984526052751312107551780405634429777115728887050743268313912761181210749971358034456362956485671758337969347823410538413405559362778500756815910262206887797628818333181584159119976847220715985985789384252132546410987928146573038797137794677854593174074751272353",
                32);

        System.out.println(map);
    }

}
