package com.jason.bos.service;

import com.jason.bos.model.PageBean;
import com.jason.bos.model.User;
import com.jason.bos.service.base.IBaseService;

public interface IUserService extends IBaseService<User>{
    //特有的业务方法
    public User findByTel(String tel);
    //登录
    public User login(String username,String password);

    /**
     * 修改密码
     * @param newPwd
     * @param id
     */
    public void modifyPwd(String newPwd,String id);
    public void save(User model, String[] roleIds);
    public void pageQuery(PageBean<User> pb);
}
