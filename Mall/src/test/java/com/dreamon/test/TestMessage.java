package com.dreamon.test;

import com.aliyuncs.exceptions.ClientException;
import com.dreamon.mall.exception.MessageException;
import com.dreamon.mall.exception.OutException;
import com.dreamon.mall.service.MessageService;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 短信测试接口
 * Created by wmt on 2017/7/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class TestMessage {

    @Resource(name = "msgService")
    private MessageService msgService;

    @Test
    public void sendMessage(){
//        assertNotNull(msgService);
        try {
            msgService.sendIdcodeMessage("15616034790","123456",MessageService.MSG_REGISTER_MODEL);
        } catch (ClientException e){
            e.printStackTrace();
        } catch (MessageException e){
            System.out.printf("短信发送失败");
            return ;
        } catch (OutException e){
            System.out.printf("电话号码不合法");
            return ;
        }
        System.out.printf("短信发送成功");
    }

}
