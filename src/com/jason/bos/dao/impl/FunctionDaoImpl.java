package com.jason.bos.dao.impl;

import com.jason.bos.dao.IFunctionDao;
import com.jason.bos.dao.IUserDao;
import com.jason.bos.dao.base.BaseDaoImpl;
import com.jason.bos.model.Function;
import com.jason.bos.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao{
}
