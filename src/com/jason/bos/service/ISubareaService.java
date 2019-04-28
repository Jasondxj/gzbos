package com.jason.bos.service;

import com.jason.bos.model.PageBean;
import com.jason.bos.model.Region;
import com.jason.bos.model.Subarea;
import com.jason.bos.service.base.IBaseService;

import java.util.List;

public interface ISubareaService extends IBaseService<Subarea>{

    public void pageQuery(PageBean<Subarea> pb);
}
