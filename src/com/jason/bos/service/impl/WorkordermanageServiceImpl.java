package com.jason.bos.service.impl;

import com.jason.bos.dao.IUserDao;
import com.jason.bos.model.User;
import com.jason.bos.model.Workordermanage;
import com.jason.bos.service.IUserService;
import com.jason.bos.service.IWorkordermanageService;
import com.jason.bos.service.base.BaseServiceImpl;
import com.jason.bos.utils.MD5Utils;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional//事务是由事务管理器来实现
public class WorkordermanageServiceImpl extends BaseServiceImpl<Workordermanage> implements IWorkordermanageService {
    @Autowired
    private RuntimeService runtimeService;


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

    @Override
    public List<Workordermanage> findAllWithNoStart() {
        DetachedCriteria dc=DetachedCriteria.forClass(Workordermanage.class);
        dc.add(Restrictions.eq("start","0"));
        return workordermanageDao.findByDetachedCriteria(dc);
    }

    /**
     * 启动配送流程
     * @param id
     */
    @Override
    public void start(String id) {
        Workordermanage workordermanage = workordermanageDao.find(id);
        workordermanage.setStart("1");
        Map<String,Object> info=new HashMap<String, Object>();
        info.put("orderinfo",workordermanage.toString());
        //工作单的id
        String businessId=workordermanage.getId();
        runtimeService.startProcessInstanceByKey("transfer",businessId,info);
    }
}
