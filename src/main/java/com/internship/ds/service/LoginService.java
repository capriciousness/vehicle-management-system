package com.internship.ds.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.internship.ds.dao.UserDao;
import com.internship.ds.exceptionAOP.enums.ExceptionEnums;
import com.internship.ds.exceptionAOP.exception.ZcException;
import com.internship.ds.model.User;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    public JSONObject login(ServletRequest servletRequest, String param){
        JSONObject json = Objects.requireNonNull(JSON.parseObject(param));
        String username = Objects.requireNonNull(json.getString("username"));
        String password = Objects.requireNonNull(json.getString("password"));
        val httpRequest = (HttpServletRequest)servletRequest;
        val session = httpRequest.getSession(true);

        User user = userDao.findNameAndPwd(username, password);
        if(user == null){
            throw new ZcException(ExceptionEnums.NOT_FOUND);
        }
        session.setAttribute("name",user.getUsername());
        return new JSONObject().fluentPut("errorCode",0).fluentPut("error",null).fluentPut("data",user);
    }

}
