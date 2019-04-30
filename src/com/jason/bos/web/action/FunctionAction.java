package com.jason.bos.web.action;

import com.jason.bos.model.Function;
import com.jason.bos.model.Staff;
import com.jason.bos.web.action.base.BaseAction;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FunctionAction extends BaseAction<Function> {
    /**
     * 分页查询
     */
    public void pageQuery() throws IOException {
        //1.接收参数 page[当前页] rows[每页显示多少条]
        //2.调用service,参数里传一个PageBean
        //封装条件
        /**
         * 因为Funtion模型里有page属性，然后BaseAction也有page属性
         * Struts框架把数据放在模型优先
         */
        pb.setCurrentPage(Integer.parseInt(getModel().getPage()));
        pb.setPageSize(rows);
        functionService.pageQuery(pb);
        //3.返回json数据
        responseJson(pb, new String[]{"currentPage", "pageSize", "detachedCriteria","functions","function","roles"});
    }

    @Override
    public String save() {
        functionService.save(getModel());
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
    public void listJson() throws IOException {
        List<Function> functions = functionService.findAll();
        responseJson(functions,new String[]{"function","funtions","roles"});

    }
}
