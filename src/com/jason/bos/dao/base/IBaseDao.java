package com.jason.bos.dao.base;

import com.jason.bos.model.PageBean;
import com.jason.bos.model.Region;
import com.jason.bos.model.Staff;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * 公共接口
 */
public interface IBaseDao<T> {
    //增
    public void save(T entity);

    //删
    public void delete(T entity);

    //改
    public void update(T entity);

    // 通过ID来查
    public T find(Serializable id);

    //查询表的所有数据
    public List<T> findAll();

    /**
     * 公共的更新方法
     * @param hql
     * @param objects
     */
    public void executeUpdate(String hql,Object... objects);

    /**
     * 公共的更新方法
     * @param queryName 在映射文件中写hql
     * @param objects
     */
    public void executeUpdateByQueryName(String queryName,Object... objects);

    public void saveList(List<T> list);

    /**
     * 声明公共分页方法
     * @param pb
     */
    public void pageQuery(PageBean<T> pb);

    public List<T> findByDetachedCriteria(DetachedCriteria dc);
}
