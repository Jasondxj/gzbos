package com.jason.bos.dao.impl;

import com.jason.bos.dao.IStaffDao;
import com.jason.bos.dao.base.BaseDaoImpl;
import com.jason.bos.model.PageBean;
import com.jason.bos.model.Staff;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements IStaffDao {

}
