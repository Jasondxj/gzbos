package com.jason.bos.web.action;

import com.jason.bos.model.Subarea;
import com.jason.bos.service.ISubareaService;
import com.jason.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class SubareaAction extends BaseAction<Subarea> {
    @Autowired
    private ISubareaService subareaService;


    @Override
    public String save() {
        subareaService.save(getModel());
        return SUCCESS;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String delete() throws IOException {
        return null;
    }

    @Override
    public String list() {
        return null;
    }
    public void pageQuery() throws IOException {
        pb.setCurrentPage(page);
        pb.setPageSize(rows);
        subareaService.pageQuery(pb);
        //3.返回json数据
        responseJson(pb, new String[]{"currentPage", "pageSize", "detachedCriteria","subareas"});
    }
}
