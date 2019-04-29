package com.jason.bos.web.action;

import com.jason.bos.model.Noticebill;
import com.jason.bos.web.action.base.BaseAction;
import com.jason.crm.domain.Customer;

import java.io.IOException;

/**
 * 业务通知单，客服接电话下单
 */
public class NoticebillAction extends BaseAction<Noticebill>{
    private String tel;

    public void setTel(String tel) {
        this.tel = tel;
    }
    public void findCustomerByTel() throws IOException {
        Customer customer = customerService.findCustomerByTel(tel);
        responseJson(customer,new String[]{});
    }

    private String decidedzoneId;

    public void setDecidedzoneId(String decidedzoneId) {
        this.decidedzoneId = decidedzoneId;
    }

    @Override
    public String save() {
        noticebillService.save(getModel(),decidedzoneId);
        return null;
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
