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
public class RegisterService {
    @Autowired
    private UserDao userDao;

    public JSONObject register(ServletRequest servletRequest, String param){
        val p = Objects.requireNonNull(JSON.parseObject(param));
        JSONObject json = Objects.requireNonNull(p.getJSONObject("user"));
        User user = JSONObject.toJavaObject(json, User.class);

        Long id = userDao.findId(user.getUsername());
        if(id != null){
            throw new ZcException(ExceptionEnums.REGISTER_FAILED);
        }
        else{
            userDao.insertUser(user);
        }
        return null;
    }
}
