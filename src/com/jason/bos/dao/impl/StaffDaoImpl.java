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
    @Override
    public void pageQuery(PageBean<Staff> pb) {

        //执行查询
        //1.查询总记录数
        //获取离线查询对象
        DetachedCriteria detachedCriteria = pb.getDetachedCriteria();
        //设置查询总记录数的条件
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = hibernateTemplate.findByCriteria(detachedCriteria);
        Long totalCount = list.get(0);
        pb.setTotal(totalCount.intValue());
        //2.查询分页数据
        detachedCriteria.setProjection(null);//把之前的条件清空
        int start=(pb.getCurrentPage()-1)*pb.getPageSize();
        int length=pb.getPageSize();
        List<Staff> staffs = hibernateTemplate.findByCriteria(detachedCriteria, start, length);
        pb.setRows(staffs);
    }

}
