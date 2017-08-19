package com.dreamon.mall.base;

import com.dreamon.mall.exception.DaoException;
import com.dreamon.mall.exception.IllegalArguementException;
import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by qiumengsong on 2017/7/27.
 */
@Component
public class BaseDao implements Status {

    @Resource
    private SessionFactory sessionFactory;

    private Session session ;



    /**
     * 添加一条数据,不用传入id
     * @param entity
     * @throws BaseException id或者name重复时抛出此异常
     * @throws IllegalArguementException 传入参数为null时抛出此异常
     */
    public void add(BaseEntity entity) throws DaoException,IllegalArguementException{
        if (entity == null){
            throw new IllegalArguementException(PARAM_EMPTY,PARAM_EMPTY_STR);
        }
        try {
            before();
            session.save(entity);
            after();
        } catch (JDBCException e){
            e.printStackTrace();
            throw new DaoException(DB_ADD_FAIL,DB_ADD_FAIL_STR);
        }
    }

    /**
     *  通过id获取数据
     * @param entity
     * @return 如果参数为null或者对应id的数据不存在，返回null
     */
    public BaseEntity get(BaseEntity entity) {
        if (entity == null)
            return entity;
        before();
        BaseEntity result = (BaseEntity)session.get(entity.getClass(),entity.getId());
        after();
        return result;
    }

    /**
     * 条件查询
     * @param entity
     * @param pageIdex
     * @param pageSize
     * @return
     */
    public List<BaseEntity> getAll(BaseEntity entity,int pageIdex,int pageSize){
        before();
        Query query = toSelectSql(entity.getMessage(),entity.getClass());
        if (pageIdex >= 0 && pageSize > 0) {
            //设置分页
            query.setFirstResult(pageIdex*pageSize);
            query.setMaxResults(pageSize);
        }
        List list = query.list();
        after();
        return list;
    }

    /**
     * 获取表中全部的数据
     * @param cls
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<BaseEntity> getAll(Class cls,int pageIndex,int pageSize){
        before();
        String sql = "from "+ cls.getName();
        Query query = session.createQuery(sql);
        if (pageIndex >= 0 && pageSize > 0) {
            //设置分页
            query.setFirstResult(pageIndex*pageSize);
            query.setMaxResults(pageSize);
        }
        List list = query.list();
        after();
        return list;
    }

    /**
     * 更新数据
     * @param value
     * @param param
     * @throws IllegalArguementException
     */
    public void update(BaseEntity value, BaseEntity param) throws IllegalArguementException{
        before();
        Query query = toUpdateSql(value.getMessage(),param.getMessage(),value.getClass());
        query.executeUpdate();
        after();
    }

    public void delete(BaseEntity entity) {
        before();
        session.delete(entity);
        after();
    }

    /**
     * 获取查询query对象的方法
     * @param valueMap
     * @param paramMap
     * @param entityClass
     * @return
     * @throws IllegalArguementException valueMap参数为null时抛出此异常
     */
    private Query toUpdateSql(Map<String,Object> valueMap, Map<String,Object> paramMap, Class entityClass) throws IllegalArguementException{
        boolean hasWhere = false;

        //sql set部分
        String sql = "update  " + entityClass.getName() + " set ";
        if (valueMap == null || valueMap.size() == 0){
            throw new IllegalArguementException(DB_EMPTY_UPDATE_PARAM,DB_EMPTY_UPDATE_PARAM_STR);
        }
        Set<String> index = valueMap.keySet();
        for (String indexStr:
                index) {
            sql += (indexStr + "=:value" + indexStr + ",");
        }
        //去掉最后的","
        sql = sql.substring(0,sql.length() - 1);

        //SQL where部分
        if (paramMap != null && paramMap.size() != 0){
            sql += " where ";
            index = paramMap.keySet();
            for (String indexStr:
                    index) {
                sql += (indexStr + "=:param" + indexStr + " and ");
            }
            //去掉最后的"and "部分
            sql = sql.substring(0,sql.length() - "and ".length());
        }

        //赋值
        System.out.println(sql);
        Query query = session.createQuery(sql);
        index = valueMap.keySet();
        for (String indexStr:
                index) {
            query.setParameter("value"+indexStr,valueMap.get(indexStr));
        }
        index = paramMap.keySet();
        for (String indexStr:
                index) {
            query.setParameter("param"+indexStr,paramMap.get(indexStr));
        }

        return query;
    }

    private Query toSelectSql(Map<String,Object> paramMap,  Class entityClass){
        boolean hasWhere = false;
        String sql = "from " + entityClass.getName();


        //添加参数
        Set<String> index = paramMap.keySet();
        if (index.size() != 0){
            //添加where
            sql += " where 1=1";
            for (String indexStr:
                    index) {
                sql += (" and "+indexStr + "=:" + indexStr);
            }
        }

        System.out.println(sql);
        Query query = session.createQuery(sql);
        //赋值
        for (String indexStr:
                index) {
            query.setParameter(indexStr,paramMap.get(indexStr));
        }

        return query;
    }

    /**
     * CURD的前置方法
     */
    public void before(){
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

//    private boolean started = false;
//    private boolean stoped = true;

    /**
     * CURD的后置方法
     */
    public void after(){
        session.getTransaction().commit();
        session.close();
    }

}

