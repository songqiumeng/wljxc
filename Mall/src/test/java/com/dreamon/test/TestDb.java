package com.dreamon.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * DB测试类
 * Created by qiumengsong on 2017/7/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class TestDb {

    private static ClassPathXmlApplicationContext app;

    @BeforeClass
    public static void initSpring(){
        try {
            app = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/applicationContext.xml"});
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Resource
    SessionFactory sessionFactory;

    @Test
    public void testSessionFactory(){
//        SessionFactory sessionFactory = (SessionFactory)app.getBean("sessionFacotry");
        Assert.assertNotNull(sessionFactory);
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        User user = new User(3,"123","123");
//        session.save(user);

        session.getTransaction().commit();
        session.close();

    }

}
