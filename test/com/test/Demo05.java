package com.test;

import com.jason.bos.dao.IFunctionDao;
import com.jason.bos.model.Function;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class Demo05 {

    @Autowired
    private IFunctionDao functionDao;

    //测试Dao
    @Test
    public void test1(){
       List<Function> functions = functionDao.findListByUserId("4028813f6a6cade2016a6cb2ca400001");
        System.out.println("size:" + functions.size());
       for(Function f : functions){
           System.out.println(f.getId() + ":" + f.getName());
       }
    }
    @Autowired
    private RuntimeService runtimeService;
    @Test
    public void test2(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("bxyy","公费花销");//报销原因
        map.put("bxje",5000);//报销金额
        map.put("employeeName","王五");
        //启动流程实例
        runtimeService.startProcessInstanceByKey("bxlc",map);
    }
    @Autowired
    private TaskService taskService;
    @Test
    public void test3(){
        taskService.complete("307");
    }
}
