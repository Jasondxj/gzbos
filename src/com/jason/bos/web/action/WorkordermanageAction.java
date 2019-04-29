package com.jason.bos.web.action;

import com.jason.bos.model.User;
import com.jason.bos.model.Workordermanage;
import com.jason.bos.web.action.base.BaseAction;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

    @Override
    public String list() {
        return null;
    }
}
