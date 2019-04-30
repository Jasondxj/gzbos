package com.jason.bos.service;

import com.jason.bos.model.Function;
import com.jason.bos.model.PageBean;
import com.jason.bos.model.User;
import com.jason.bos.service.base.IBaseService;

public interface IFunctionService extends IBaseService<Function>{
  public void pageQuery(PageBean<Function> pb);
}
