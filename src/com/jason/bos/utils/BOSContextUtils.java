package com.jason.bos.utils;

import com.jason.bos.model.User;
import org.apache.struts2.ServletActionContext;

public class BOSContextUtils {
    public static User loginUser(){
        return (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
    }
}
