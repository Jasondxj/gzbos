package com.test;

import com.jason.bos.dao.IFunctionDao;
import com.jason.bos.model.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
}
