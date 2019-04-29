package com.jason.bos.dao.impl;

import com.jason.bos.dao.IUserDao;
import com.jason.bos.dao.IWorkbillDao;
import com.jason.bos.dao.base.BaseDaoImpl;
import com.jason.bos.model.User;
import com.jason.bos.model.Workbill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkbillDaoImpl extends BaseDaoImpl<Workbill> implements IWorkbillDao{
}
