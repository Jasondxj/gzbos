package com.jason.bos.service.impl;

import com.jason.bos.dao.IStaffDao;
import com.jason.bos.dao.IUserDao;
import com.jason.bos.model.PageBean;
import com.jason.bos.model.Staff;
import com.jason.bos.model.User;
import com.jason.bos.service.IStaffService;
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
public class StaffServiceImpl extends BaseServiceImpl<Staff> implements IStaffService {
    @Autowired
    private IStaffDao staffDao;


    @Override
    public void save(Staff entity) {
        staffDao.save(entity);
    }

    @Override
    public void delete(Staff entity) {
        staffDao.delete(entity);
    }

    @Override
    public void update(Staff entity) {
        staffDao.update(entity);
    }

    @Override
    public Staff find(Serializable id) {
        return staffDao.find(id);
    }

    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public void pageQuery(PageBean<Staff> pb) {
        staffDao.pageQuery(pb);
    }
}
