package com.jason.bos.dao;

import com.jason.bos.dao.base.IBaseDao;
import com.jason.bos.model.User;

public interface IUserDao extends IBaseDao<User>{
    public User findByEmail(String email);
    public User find(String username,String password);
}
