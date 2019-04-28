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
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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

    @Override
    public void deleteBatch(String ids) {
        String hql = "UPDATE Staff SET deltag = ? WHERE id = ?";

        //拆分id
        String[] idsArr = ids.split(",");
        for (String id : idsArr){
            staffDao.executeUpdate(hql,"1",id);
            //staffDao.executeUpdateByQueryName("staff.delete","1",id);
        }
    }

    @Override
    public List<Staff> findAllByNoDelete() {
        //离线查询对象
        DetachedCriteria dc=DetachedCriteria.forClass(Staff.class);
        dc.add(Restrictions.eq("deltag","0"));
        return staffDao.findByDetachedCriteria(dc);
    }
}
