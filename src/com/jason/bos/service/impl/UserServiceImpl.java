package com.jason.bos.service.impl;

import com.jason.bos.dao.IUserDao;
import com.jason.bos.model.PageBean;
import com.jason.bos.model.Role;
import com.jason.bos.model.User;
import com.jason.bos.service.IUserService;
import com.jason.bos.service.base.BaseServiceImpl;
import com.jason.bos.utils.MD5Utils;
import org.activiti.engine.IdentityService;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
    @Autowired
    private IdentityService identityService;
    @Override
    public User findByTel(String tel) {
        return null;
    }

    @Override
    public User login(String username, String password) {
        return userDao.find(username, MD5Utils.text2md5(password));
    }

    @Override
    public void modifyPwd(String newPwd, String id) {
        /*String hql = "update User set password=? where id=?";
        userDao.executeUpdate(hql, MD5Utils.text2md5(newPwd), id);*/

        userDao.executeUpdateByQueryName("updatePwd",MD5Utils.text2md5(newPwd),id);
    }

    /**
     * 保存用户
     * @param model
     * @param roleIds
     */
    @Override
    public void save(User model, String[] roleIds) {
        //保存到t_user表
        userDao.save(model);
        //保存到activity的ac_id_user表
        org.activiti.engine.identity.User actUser=new UserEntity();
        actUser.setId(model.getId());
        actUser.setFirstName(model.getUsername());
        identityService.saveUser(actUser);
        //用户拥有的角色
        for (String roleId : roleIds){
            Role role =roleDao.find(roleId);
//            role.setId(roleId);
            model.getRoles().add(role);
            //维护activity用户跟组的关系
            String userId=actUser.getId();
            String groupId=role.getName();
            identityService.createMembership(userId,groupId);
        }
    }

    @Override
    public void pageQuery(PageBean<User> pb) {
        userDao.pageQuery(pb);
    }

    @Override
    public void save(User entity) {
        userDao.save(entity);
    }

    @Override
    public void delete(User entity) {
        userDao.delete(entity);
    }

    @Override
    public void update(User entity) {
        userDao.update(entity);
    }

    @Override
    public User find(Serializable id) {
        return userDao.find(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
