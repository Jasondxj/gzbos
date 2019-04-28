package com.jason.bos.dao;

import com.jason.bos.dao.base.IBaseDao;
import com.jason.bos.model.PageBean;
import com.jason.bos.model.Staff;

public interface IStaffDao extends IBaseDao<Staff> {
    /**
     * 分页查询
     * @param pb
     */
    public void pageQuery(PageBean<Staff> pb);
}
