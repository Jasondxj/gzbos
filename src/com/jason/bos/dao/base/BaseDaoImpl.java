package com.jason.bos.dao.base;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> implements IBaseDao<T> {
    private Class<T> entityClass;

    public BaseDaoImpl() {
        //获取泛型的真实类型
        /**
         * 1.this.getClass().getGenericSuperclass()获取泛型父类
         * 2.ParameterizedType 参数类型
         */
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取泛型真实类型
        Type[] types = pt.getActualTypeArguments();

        //把type类型赋值给Class类型
        entityClass = (Class<T>) types[0];
        //System.out.println(entityClass);
       /* for (Type type : types){
            System.out.println(type);
        }*/
    }

    @Autowired
    protected HibernateTemplate hibernateTemplate;

    @Override
    public void save(T entity) {
        hibernateTemplate.save(entity);
    }

    @Override
    public void delete(T entity) {
        hibernateTemplate.delete(entity);
    }

    @Override
    public void update(T entity) {
        hibernateTemplate.update(entity);
    }

    @Override
    public T find(Serializable id) {
        return this.hibernateTemplate.get(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        //entityClass.getSimpleName() 获取类名
        String hql = "from " + entityClass.getSimpleName();
        return this.hibernateTemplate.find(hql);
    }

    @Override
    public void executeUpdate(String hql, Object... objects) {
        Session currentSession = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query = currentSession.createQuery(hql);
        for (int i = 0; i <objects.length ; i++) {
            query.setParameter(i,objects[i]);
        }
        query.executeUpdate();
    }

    @Override
    public void executeUpdateByQueryName(String queryName, Object... objects) {
        Session currentSession = hibernateTemplate.getSessionFactory().getCurrentSession();
        //从映射文件拿到queryname，并返回query对象
        Query query=currentSession.getNamedQuery(queryName);
        for (int i = 0; i <objects.length ; i++) {
            query.setParameter(i,objects[i]);
        }
        query.executeUpdate();
    }
}
