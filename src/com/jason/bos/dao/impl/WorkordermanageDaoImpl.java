package com.jason.bos.dao.impl;

import com.jason.bos.dao.IUserDao;
import com.jason.bos.dao.IWorkordermanageDao;
import com.jason.bos.dao.base.BaseDaoImpl;
import com.jason.bos.model.User;
import com.jason.bos.model.Workordermanage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkordermanageDaoImpl extends BaseDaoImpl<Workordermanage> implements IWorkordermanageDao{
}
