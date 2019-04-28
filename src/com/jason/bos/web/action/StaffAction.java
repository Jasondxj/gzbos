package com.jason.bos.web.action;

import com.jason.bos.model.PageBean;
import com.jason.bos.model.Staff;
import com.jason.bos.model.User;
import com.jason.bos.service.IStaffService;
import com.jason.bos.service.IUserService;
import com.jason.bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
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

    /**
     * 分页查询
     */
    private int page;
    private int row;

    public void setPage(int page) {
        this.page = page;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void pageQuery() throws IOException {
        PageBean<Staff> pb=new PageBean<Staff>();
        pb.setCurrentPage(page);
        pb.setPageSize(row);
        //查询条件
        DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
        pb.setDetachedCriteria(dc);
        staffService.pageQuery(pb);
        //返回json数据
        //3.1排除不需要转json的属性
        JsonConfig config = new JsonConfig();
        config.setExcludes(new String[]{"currentPage","pageSize","detachedCriteria"});
        //3.2创建json对象
        JSONObject jsonObject = JSONObject.fromObject(pb,config);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonObject.toString());
    }
}
