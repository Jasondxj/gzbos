package com.jason.bos.service;

import com.jason.bos.model.PageBean;
import com.jason.bos.model.Role;
import com.jason.bos.service.base.IBaseService;

public interface IRoleService extends IBaseService<Role> {


    /**
     *
     * @param role 角色模型
     * @param funtionIds 权限、功能id
     */
    public void save(Role role, String funtionIds);


    public void pageQuery(PageBean<Role> pb);
}
