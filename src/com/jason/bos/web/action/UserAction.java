package com.jason.bos.web.action;

import com.jason.bos.model.User;
import com.jason.bos.service.IUserService;
import com.jason.bos.utils.MD5Utils;
import com.jason.bos.web.action.base.BaseAction;
import com.mchange.v1.util.ArrayUtils;
import org.activiti.engine.RepositoryService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserAction extends BaseAction<User> {

    //创建一个日志对象
    Logger logger = Logger.getLogger(UserAction.class);

    @Autowired
    private RepositoryService rs;

    public String login() {
        logger.info(getModel());
        logger.warn(getModel());
        logger.error(getModel());
        String username = getModel().getUsername();
        String password = getModel().getPassword();
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String serverCode = (String) session.getAttribute("key");
        String clientCode = request.getParameter("checkcode");
        if (serverCode.equalsIgnoreCase(clientCode)) {
            /**
             * 使用shiro，就不再使用userService的login方法来登录
             * 而是使用Subject的login方法
             */
            //获取一个Subject
            Subject subject = SecurityUtils.getSubject();
            //创建一个Token,这个对象存着用户名和密码
            UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Utils.text2md5(password));
            try {
                subject.login(token);//内部就会执行Realm的代码
                //登陆成功
                User loginUser = (User) subject.getPrincipal();
                subject.getSession().setAttribute("loginUser", loginUser);
                return "home";
            } catch (AuthenticationException e) {
                e.printStackTrace();//登录失败会抛出异常
                addActionError("用户名或密码不正确");
            }


        } else {
            addActionError("验证码错误");
        }
        return "loginfailure";
    }
    private String[] roleIds;

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }
    @Override
    public String save() {
        System.out.println(getModel());
        System.out.println(ArrayUtils.toString(roleIds));

        //修改密码
        String pwd = MD5Utils.text2md5(getModel().getPassword());
        getModel().setPassword(pwd);

        if(roleIds != null && roleIds.length != 0){
            userService.save(getModel(),roleIds);
        }else{
            logger.info("roleIds不能为空....");
        }


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

    public String logout() {
        ServletActionContext.getRequest().getSession().invalidate();
        return "login";
    }

    public String editPassword() throws IOException {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String newPwd = getModel().getPassword();
        User user = (User) request.getSession().getAttribute("loginUser");
        String userId = user.getId();
        userService.modifyPwd(newPwd, userId);
//        response.setHeader("content-type","text/json;charset=utf-8");
//        response.setContentType("text/json;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print("{\"success\":\"1\"}");
        return NONE;
    }
    public void pageQuery() throws IOException {
        pb.setCurrentPage(page);
        pb.setPageSize(rows);
        userService.pageQuery(pb);
        responseJson(pb,new String[]{"currentPage","pageSize","detachedCriteria","roles"});

    }
}
