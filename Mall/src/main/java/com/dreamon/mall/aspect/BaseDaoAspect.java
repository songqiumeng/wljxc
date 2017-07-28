package com.dreamon.mall.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * BaseDao的切面
 * Created by qiumengsong on 2017/7/28.
 */
@Aspect
public class BaseDaoAspect {

    /**
     * 切点的前置方法
     */
    public void before(){

    }

    /**
     * 切点的后置方法
     */
    public void after(){

    }

    /**
     * add操作的切点
     * */
    @Pointcut("execution(** com.dreamon.mall.base.BaseDao.add(..))")
    public void addPerformance(){}

    @Before("addPerformance")
    public void beforeAdd(){
        before();
    }

    @After("addPerformance()")
    public void afterAdd(){
        after();
    }

}
