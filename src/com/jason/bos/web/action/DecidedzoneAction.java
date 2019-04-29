package com.jason.bos.web.action;

import com.jason.bos.model.Decidedzone;
import com.jason.bos.service.IDecidedzoneService;
import com.jason.bos.web.action.base.BaseAction;
import com.jason.crm.domain.Customer;
import com.jason.crm.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class DecidedzoneAction extends BaseAction<Decidedzone> {


    private String[] subareaId;//分区的id

    public void setSubareaId(String[] subareaId) {
        this.subareaId = subareaId;
    }



    @Override
    public String save() {
        System.out.println("参数:" + getModel());
        System.out.println("参数:" + getModel().getStaff());
        System.out.println("参数:" + StringUtils.join(subareaId, "，"));
        //调用service
        decidedzoneService.save(getModel(), subareaId);
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

        //2.调用service,参数里传一个PageBean
        decidedzoneService.pageQuery(pb);

        //3.返回json数据
        responseJson(pb, new String[]{"currentPage", "pageSize", "detachedCriteria"});

    }



    /**
     * 获取未关联定区的客户信息
     */
    public void findnoassociationCustomers() throws IOException {
        List<Customer> customers = customerService.findnoassociationCustomers();
        responseJson(customers, new String[]{});
    }
    /**
     * 获取关联定区的客户信息
     */
    public void findhasassociationCustomers() throws IOException {
        List<Customer> customers = customerService.findhasassociationCustomers(getModel().getId());
        responseJson(customers, new String[]{});
    }

    /**
     * 关联客户到定区
     *
     * @return
     */
    private Integer[] customerIds;

    public void setCustomerIds(Integer[] customerIds) {
        this.customerIds = customerIds;
    }

    public String assigncustomerstodecidedzone() {
        //客户id数组和定区id
        //远程调用
        customerService.assignCustomersToDecidedZone(customerIds, getModel().getId());
        return SUCCESS;
    }
}
