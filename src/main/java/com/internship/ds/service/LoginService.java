package com.internship.ds.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.internship.ds.dao.LoginDao;
import com.internship.ds.exceptionAOP.enums.ExceptionEnums;
import com.internship.ds.exceptionAOP.exception.ZcException;
import com.internship.ds.model.LoginInformation;
import lombok.val;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public JSONObject login(ServletRequest servletRequest, String param){
        JSONObject p = Objects.requireNonNull(JSON.parseObject(param));
        String name = Objects.requireNonNull(p.getString("username"));
        String password = Objects.requireNonNull(p.getString("password"));
        val httpRequest = (HttpServletRequest)servletRequest;
        val session = httpRequest.getSession(true);
        LoginInformation namePassword = loginDao.findNamePassword("zs", password);
        if(namePassword == null){
            throw new ZcException(ExceptionEnums.NOT_FOUND);
        }
        session.setAttribute("name",namePassword.getName());
        return new JSONObject().fluentPut("errorCode",0).fluentPut("error",null).fluentPut("data",namePassword);
    }
}
