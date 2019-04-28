package com.jason.bos.service;

import com.jason.bos.model.PageBean;
import com.jason.bos.model.Staff;
import com.jason.bos.model.User;
import com.jason.bos.service.base.IBaseService;

public interface IStaffService extends IBaseService<Staff>{

    /**
     * 分页查询
      * @param pb
     */
    public void pageQuery(PageBean<Staff> pb);
}
