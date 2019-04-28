package com.jason.bos.web.action;

import com.jason.bos.model.Staff;
import com.jason.bos.model.User;
import com.jason.bos.service.IStaffService;
import com.jason.bos.service.IUserService;
import com.jason.bos.web.action.base.BaseAction;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StaffAction extends BaseAction<Staff> {
    @Autowired
    private IStaffService staffService;

    @Override
    public String save() {
        staffService.save(getModel());
        return SUCCESS;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }

    @Override
    public String list() {
        return null;
    }
}
