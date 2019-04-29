package com.test;

import com.caucho.hessian.client.HessianProxyFactory;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Hessian的使用
 */
public class Demo04 {

    @Test
    public void test1() throws MalformedURLException {
        //访问另一个项目的数据，使用远程调用Hessian
        //1.创建一个代理对象
        HessianProxyFactory factory = new HessianProxyFactory();

        ICustomerService customerService = (ICustomerService) factory.create(ICustomerService.class,"http://localhost:8080/hessian/customer");

        List<Customer> list = customerService.findAll();
        System.out.println(list);
    }

}
