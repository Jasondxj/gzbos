package com.test;

import com.jason.bos.model.User;
import com.jason.bos.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class Demo02 {

    @Autowired
    private IUserService userService;
    //测试Dao
    @Test
    public void test1(){
        //1.创建User
        User user = new User();
        user.setUsername("gyf");
        user.setPassword("123");

        //2.保存
        userService.save(user);
    }
    @Test
    public void test2(){
        //在dao中抽取一个公共的执行hql的方法
        /**
         * 1.public void executeUpdate(String hql, Object... objs)
         * 2.public void executeUpdateByQueryName(String queryName, Object... objs)
         *   step01: queryName是在映射文件中配置一个查询hql语句
         *   step02:
         */
        userService.modifyPwd("123","4028813f6a5e84c1016a5e84c3d30000");
    }
}
