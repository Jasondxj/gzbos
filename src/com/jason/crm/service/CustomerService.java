package com.jason.crm.service;


import com.jason.crm.domain.Customer;

import java.util.List;


// 客户服务接口 
public interface CustomerService {
    //通过手机号查找客户信息
    public Customer findCustomerByTel(String tel);
	// 未关联定区客户
	public List<Customer> findnoassociationCustomers();

	// 查询已经关联指定定区的客户
	public List<Customer> findhasassociationCustomers(String decidedZoneId);

	// 将未关联定区客户关联到定区上
	public void assignCustomersToDecidedZone(Integer[] customerIds, String decidedZoneId);
}
