package com.jason.bos.service;

import com.jason.bos.model.Noticebill;
import com.jason.bos.model.User;
import com.jason.bos.service.base.IBaseService;

public interface INoticebillService extends IBaseService<Noticebill>{
    /**
     *
     * @param noticebill 业务通知单模型
     * @param decidedId   定区id，用于自动分单
     */
    public void save(Noticebill noticebill,String decidedId);

}
