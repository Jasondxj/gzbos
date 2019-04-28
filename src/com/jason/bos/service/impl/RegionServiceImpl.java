package com.jason.bos.service.impl;

import com.jason.bos.dao.IRegionDao;
import com.jason.bos.dao.IStaffDao;
import com.jason.bos.model.PageBean;
import com.jason.bos.model.Region;
import com.jason.bos.model.Staff;
import com.jason.bos.service.IRegionService;
import com.jason.bos.service.IStaffService;
import com.jason.bos.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class RegionServiceImpl extends BaseServiceImpl<Region> implements IRegionService {
    @Autowired
    private IRegionDao regionDao;

    @Override
    public void save(Region entity) {
        regionDao.save(entity);
    }

    @Override
    public void delete(Region entity) {

    }

    @Override
    public void update(Region entity) {

    }

    @Override
    public Region find(Serializable id) {
        return null;
    }

    @Override
    public List<Region> findAll() {
        return null;
    }

    @Override
    public void saveAll(List<Region> list) {
        regionDao.saveList(list);
    }

    @Override
    public void pageQuery(PageBean<Region> pb) {
        regionDao.pageQuery(pb);
    }
}
