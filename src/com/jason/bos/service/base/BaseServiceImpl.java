package com.jason.bos.service.base;

import com.jason.bos.dao.IDecidedzoneDao;
import com.jason.bos.dao.INoticebillDao;
import com.jason.bos.dao.IWorkbillDao;
import com.jason.bos.dao.IWorkordermanageDao;
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

}
