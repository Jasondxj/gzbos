package com.jason.bos.service.base;

import com.jason.bos.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {
    @Autowired
    protected INoticebillDao noticebillDao;
    @Autowired
    protected IDecidedzoneDao decidedzoneDao;
    @Autowired
    protected IWorkbillDao workbillDao;
    @Autowired
    protected IWorkordermanageDao workordermanageDao;
    @Autowired
    protected IFunctionDao functionDao;
    @Autowired
    protected IRoleDao roleDao;
    @Autowired
    protected IUserDao userDao;

}
