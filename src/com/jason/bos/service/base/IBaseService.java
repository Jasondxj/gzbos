package com.jason.bos.service.base;

import com.jason.bos.model.PageBean;
import com.jason.bos.model.Region;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {
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


}
