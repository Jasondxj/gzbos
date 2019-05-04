package com.jason.bos.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.List;
import java.util.zip.ZipInputStream;

public class ProcessDefinitionAction extends ActionSupport {
    //仓库的service
    @Autowired
    private RepositoryService repositoryService;

    private List<ProcessDefinition> list;

    public List<ProcessDefinition> getList() {
        return list;
    }

    public String list() {
        //查询流程定义
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        query.orderByDeploymentId().desc();
        list = query.list();
        //数据存在值栈中,提供list的get方法
        return "list";
    }

    private File zipFile;

    public void setZipFile(File zipFile) {
        this.zipFile = zipFile;
    }

    //发布一个流程
    public String deploy() throws FileNotFoundException {
        //获取部署对象
        DeploymentBuilder builder = repositoryService.createDeployment();
        //2.builder 添加压缩包输入流
        builder.addZipInputStream(new ZipInputStream(new FileInputStream(zipFile)));
        //3.部署
        builder.deploy();
        //查询最新的流程数据
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        query.orderByDeploymentId().desc();
        list = query.list();
        return "list";
    }

    //显示流程图
    private String id;//流程定义id

    public void setId(String id) {
        this.id = id;
    }

    public String viewpng() {
        //返回一张图片给客户端
        //根据流程id获取图片
        InputStream processDiagram = repositoryService.getProcessDiagram(id);
        //把processDiagram放在值栈
        ActionContext.getContext().getValueStack().set("processDiagram", processDiagram);
        return "viewpng";
    }

    public void del() throws IOException {
//1.先根据流程定义id查找部署id
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        query.processDefinitionId(id);
        ProcessDefinition processDefinition = query.singleResult();
        String deploymentId=processDefinition.getDeploymentId();
        repositoryService.deleteDeployment(deploymentId);
        ServletActionContext.getResponse().getWriter().write("success");
    }
}
