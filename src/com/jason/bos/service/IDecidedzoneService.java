package com.jason.bos.service;

import com.jason.bos.model.Decidedzone;
import com.jason.bos.model.PageBean;
import com.jason.bos.service.base.IBaseService;

import java.util.List;

public interface IDecidedzoneService extends IBaseService<Decidedzone> {


    /**
     *
     * @param dz 定区数据
     * @param subareaIds 分区的ids
     */
    public void save(Decidedzone dz, String[] subareaIds);

    public void pageQuery(PageBean<Decidedzone> pb);
}
