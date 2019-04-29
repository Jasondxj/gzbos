package com.jason.bos.web.action;

import com.jason.bos.model.User;
import com.jason.bos.service.IUserService;
import com.jason.bos.web.action.base.BaseAction;
import org.apache.struts2.ServletActionContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserAction extends BaseAction<User> {

    public String login() {
        String username = getModel().getUsername();
        String password = getModel().getPassword();
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String serverCode = (String) session.getAttribute("key");
        String clientCode = request.getParameter("checkcode");
        if (serverCode.equalsIgnoreCase(clientCode)){//验证码正确
            User user = userService.login(username, password);
            if (user!=null){
                session.setAttribute("loginUser",user);
                return "home";//主页面
            }else {
                addActionError("用户名或密码不正确");
            }
        }else {
            addActionError("验证码错误");
        }
        return "loginfailure";
    }

    @Override
    public String save() {
        return null;
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
    public String logout(){
        ServletActionContext.getRequest().getSession().invalidate();
        return "login";
    }
    public String editPassword() throws IOException {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String newPwd=getModel().getPassword();
        User user = (User)request.getSession().getAttribute("loginUser");
        String userId=user.getId();
        userService.modifyPwd(newPwd,userId);
//        response.setHeader("content-type","text/json;charset=utf-8");
//        response.setContentType("text/json;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print("{\"success\":\"1\"}");
        return NONE;
    }
}
