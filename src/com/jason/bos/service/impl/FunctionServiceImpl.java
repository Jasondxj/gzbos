package com.jason.bos.service.impl;

import com.jason.bos.dao.IUserDao;
import com.jason.bos.model.Function;
import com.jason.bos.model.PageBean;
import com.jason.bos.model.User;
import com.jason.bos.service.IFunctionService;
import com.jason.bos.service.IUserService;
import com.jason.bos.service.base.BaseServiceImpl;
import com.jason.bos.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class FunctionServiceImpl extends BaseServiceImpl<Function> implements IFunctionService {

    @Override
    public void save(Function entity) {
        functionDao.save(entity);
    }

    @Override
    public void delete(Function entity) {

    }

    @Override
    public void update(Function entity) {

    }

    @Override
    public Function find(Serializable id) {
        return null;
    }

    @Override
    public List<Function> findAll() {
        return functionDao.findAll();
    }

    @Override
    public void pageQuery(PageBean<Function> pb) {
        functionDao.pageQuery(pb);
    }
}
