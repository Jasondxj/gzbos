package com.jason.bos.service;

import com.jason.bos.model.User;
import com.jason.bos.model.Workordermanage;
import com.jason.bos.service.base.IBaseService;

import java.util.List;

public interface IWorkordermanageService extends IBaseService<Workordermanage>{
    public List<Workordermanage> findAllWithNoStart();

    public void start(String id);
}
