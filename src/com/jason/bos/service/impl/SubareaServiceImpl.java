package com.jason.bos.service.impl;

import com.jason.bos.dao.IRegionDao;
import com.jason.bos.dao.ISubareaDao;
import com.jason.bos.model.PageBean;
import com.jason.bos.model.Region;
import com.jason.bos.model.Subarea;
import com.jason.bos.service.IRegionService;
import com.jason.bos.service.ISubareaService;
import com.jason.bos.service.base.BaseServiceImpl;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class SubareaServiceImpl extends BaseServiceImpl<Subarea> implements ISubareaService {
    @Autowired
    private ISubareaDao subareaDao;

    @Override
    public void save(Subarea entity) {
        subareaDao.save(entity);
    }

    @Override
    public void delete(Subarea entity) {

    }

    @Override
    public void update(Subarea entity) {

    }

    @Override
    public Subarea find(Serializable id) {
        return null;
    }

    @Override
    public List<Subarea> findAll() {
        return subareaDao.findAll();
    }

    @Override
    public void pageQuery(PageBean<Subarea> pb) {
        subareaDao.pageQuery(pb);
    }

    @Override
    public List<Subarea> findAllWithUnbound() {
        DetachedCriteria dc=DetachedCriteria.forClass(Subarea.class);
        dc.add(Restrictions.isNull("decidedzone"));
        return subareaDao.findByDetachedCriteria(dc);
    }
}
