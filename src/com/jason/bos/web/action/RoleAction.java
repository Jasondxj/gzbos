package com.jason.bos.web.action;

import com.jason.bos.model.Role;
import com.jason.bos.web.action.base.BaseAction;

import java.io.IOException;
import java.util.List;

public class RoleAction extends BaseAction<Role> {


    private String functionIds;//权限id

    public void setFunctionIds(String functionIds) {
        this.functionIds = functionIds;
    }

    @Override
    public String save() {
        roleService.save(getModel(),functionIds);
        return NONE;
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

    public  void pageQuery() throws IOException {
        pb.setCurrentPage(page);
        pb.setPageSize(rows);

        //2.调用service,参数里传一个PageBean
        roleService.pageQuery(pb);

        //3.返回json数据
        responseJson(pb,new String[]{"currentPage","pageSize","detachedCriteria","users","functions"});
    }

    public void listJson() throws IOException {
        List<Role> roles = roleService.findAll();
        responseJson(roles,new String[]{"users","functions"});
    }

}
