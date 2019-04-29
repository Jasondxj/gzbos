package com.jason.bos.service.impl;

import com.jason.bos.dao.IUserDao;
import com.jason.bos.model.User;
import com.jason.bos.model.Workordermanage;
import com.jason.bos.service.IUserService;
import com.jason.bos.service.IWorkordermanageService;
import com.jason.bos.service.base.BaseServiceImpl;
import com.jason.bos.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class WorkordermanageServiceImpl extends BaseServiceImpl<Workordermanage> implements IWorkordermanageService {


    @Override
    public void save(Workordermanage entity) {
        workordermanageDao.save(entity);
    }

    @Override
    public void delete(Workordermanage entity) {

    }

    @Override
    public void update(Workordermanage entity) {

    }

    @Override
    public Workordermanage find(Serializable id) {
        return null;
    }

    @Override
    public List<Workordermanage> findAll() {
        return null;
    }
}
