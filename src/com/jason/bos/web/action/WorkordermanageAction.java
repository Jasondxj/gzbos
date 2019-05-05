package com.jason.bos.web.action;

import com.jason.bos.model.User;
import com.jason.bos.model.Workordermanage;
import com.jason.bos.web.action.base.BaseAction;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class WorkordermanageAction extends BaseAction<Workordermanage> {
    @Override
    public String save() {
        workordermanageService.save(getModel());
        try {
            responseStr("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    List<Workordermanage> list;

    public List<Workordermanage> getList() {
        return list;
    }

    @Override
    public String list() {
        //查询未启动配送流程的工作单
        list=workordermanageService.findAllWithNoStart();
        return "list";
    }
    public String start(){
        //启动工作流程
        workordermanageService.start(getModel().getId());
        return list();
    }
}
