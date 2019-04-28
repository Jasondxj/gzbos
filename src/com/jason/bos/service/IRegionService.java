package com.jason.bos.service;

import com.jason.bos.model.PageBean;
import com.jason.bos.model.Region;
import com.jason.bos.model.Staff;
import com.jason.bos.service.base.IBaseService;

import java.util.List;

public interface IRegionService extends IBaseService<Region>{

    public void saveAll(List<Region> list);

    public void pageQuery(PageBean<Region> pb);
}
