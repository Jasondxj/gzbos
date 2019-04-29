package com.jason.bos.service.impl;

import com.jason.bos.dao.IUserDao;
import com.jason.bos.model.Noticebill;
import com.jason.bos.model.Staff;
import com.jason.bos.model.User;
import com.jason.bos.model.Workbill;
import com.jason.bos.service.INoticebillService;
import com.jason.bos.service.IUserService;
import com.jason.bos.service.base.BaseServiceImpl;
import com.jason.bos.utils.BOSContextUtils;
import com.jason.bos.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class NoticebillServiceImpl extends BaseServiceImpl<Noticebill> implements INoticebillService {

    @Override
    public void save(Noticebill entity) {

    }

    @Override
    public void delete(Noticebill entity) {

    }

    @Override
    public void update(Noticebill entity) {

    }

    @Override
    public Noticebill find(Serializable id) {
        return null;
    }

    @Override
    public List<Noticebill> findAll() {
        return null;
    }

    @Override
    public void save(Noticebill entity, String decidedId) {
        //添加业务通知单类型（自动，手动）
        entity.setOrdertype("手动");
        //设置客服id
        entity.setUser(BOSContextUtils.loginUser());
        noticebillDao.save(entity);
        //自动分单（通过定区找到负责人）
        if (!StringUtils.isEmpty(decidedId)){
            entity.setOrdertype("自动");
            Staff staff = decidedzoneDao.find(decidedId).getStaff();
            entity.setStaff(staff);
            //往工单表插入数据
            //4.往 "工单" 表插入数据
            Workbill workbill = new Workbill();
            workbill.setType("新单");//工单类型：新、追、改、销
            workbill.setPickstate("未取件");//未取件-取件中-收件
            workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));//工单创建时间
            workbill.setAttachbilltimes(0);//取到快件时间
            workbill.setRemark(entity.getRemark());
            //往工单添加业务通知单的id
            workbill.setNoticebill(entity);
            workbill.setStaff(staff);
            workbillDao.save(workbill);
        }

    }
}
