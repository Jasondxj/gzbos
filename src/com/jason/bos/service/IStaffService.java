package com.jason.bos.service;

import com.jason.bos.model.PageBean;
import com.jason.bos.model.Staff;
import com.jason.bos.model.User;
import com.jason.bos.service.base.IBaseService;

import java.util.List;

public interface IStaffService extends IBaseService<Staff>{

    /**
     * 分页查询
      * @param pb
     */
    public void pageQuery(PageBean<Staff> pb);

    /**
     * 批量删除员工
     * @param ids【001,002,003】
     */
    public void deleteBatch(String ids);

    public List<Staff> findAllByNoDelete();
}
