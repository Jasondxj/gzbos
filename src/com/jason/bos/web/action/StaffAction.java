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
import java.util.List;

public class StaffAction extends BaseAction<Staff> {
    @Autowired
    private IStaffService staffService;

    @Override
    public String save() {
        staffService.save(getModel());
        return SUCCESS;
    }


    //    public String update() {
//        //getModel() 【游离/脱管状态 session没有缓存，有id】
////        System.out.println("表单提交:" + getModel());
//        staffService.update(getModel());
//        return SUCCESS;
//    }
    @Override
    public String update() {

        //getModel() 【游离/脱管状态 session没有缓存，有id】
//        System.out.println("表单提交:" + getModel());

        //1.根据id从数据库获取数据【持久状态-session有缓存，有id】
        Staff staff = staffService.find(getModel().getId());


        //2.更新数据库的数据
        staff.setName(getModel().getName());
        staff.setTelephone(getModel().getTelephone());
        staff.setStation(getModel().getStation());
        staff.setHaspda(getModel().getHaspda());
        staff.setStandard(getModel().getStandard());
//        System.out.println("数据库：" + staff);
        staffService.update(staff);
        return SUCCESS;
    }

    /**
     * 删除取派员
     */
    private String ids;

    public void setIds(String ids) {
        this.ids = ids;
    }

    @Override
    public String delete() throws IOException {
        //获取删除的id
        staffService.deleteBatch(ids);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.getWriter().write("success");
        return NONE;
    }

    @Override
    public String list() {
        return null;
    }

    /**
     * 分页查询
     */
    public void pageQuery() throws IOException {
        //1.接收参数 page[当前页] rows[每页显示多少条]
        //2.调用service,参数里传一个PageBean
        //封装条件
        pb.setCurrentPage(page);
        pb.setPageSize(rows);
        staffService.pageQuery(pb);
        //3.返回json数据
        responseJson(pb, new String[]{"currentPage", "pageSize", "detachedCriteria"});
    }

    public void listJson() throws IOException {
        //在职员工
        List<Staff> list = staffService.findAllByNoDelete();

       /* private String telephone;//手机
        private String haspda;//是否有台设备 0:无 1：有
        private String deltag = "0";//删除标志 0:正常在职 1：离职
        private String station;//所属单位
        private String standard;//收费标准*/

        responseJson(list, new String[]{"telephone", "haspda", "deltag", "station", "standard"});
    }
}
