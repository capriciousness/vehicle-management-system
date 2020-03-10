package com.internship.ds.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.internship.ds.dao.UserManageDao;
import com.internship.ds.exceptionAOP.enums.ExceptionEnums;
import com.internship.ds.exceptionAOP.exception.ZcException;
import com.internship.ds.model.UserInformation;
import com.internship.ds.model.UserPower;
import com.internship.ds.model.UserRole;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserManageService {

    @Autowired
    private UserManageDao userManageDao;


    public JSONObject userManage(String request){
        val p = Objects.requireNonNull(JSON.parseObject(request));
        JSONObject jsonObject = Objects.requireNonNull(p.getJSONObject("user"));
        UserInformation userInfo = JSONObject.toJavaObject(jsonObject, UserInformation.class);
        userManageDao.updateUserBase(userInfo);
        Integer userId = userManageDao.findUserId(userInfo.getName());
        Integer roleId = userManageDao.findUserRoleId(userInfo.getRole());
        userManageDao.updataUserRole(userId,roleId);
        return null;
    }

    public JSONObject findUserBase(String req){
        List<UserInformation> userBase = userManageDao.findUserBase();
        if(userBase == null){
            throw  new ZcException(ExceptionEnums.NOT_FOUND);
        }
        return new JSONObject().fluentPut("errorCode",0).fluentPut("error",null)
            .fluentPut("data",userBase);
    }

    public JSONObject roleManageadd(String request){
        val p = Objects.requireNonNull(JSON.parseObject(request));
        String  det = Objects.requireNonNull(p.getString("detail"));
        String  ps = Objects.requireNonNull(p.getString("ps"));
        userManageDao.addRole(det,ps);
        return null;
    }

    public JSONObject roleManagedel(String request){
        val p = Objects.requireNonNull(JSON.parseObject(request));
        String  det = Objects.requireNonNull(p.getString("detail"));
        userManageDao.delRole(det);
        return null;
    }



    public JSONObject powerManageAdd(String request){
        val p = Objects.requireNonNull(JSON.parseObject(request));
        String name = Objects.requireNonNull(p.getString("detail"));
        String ps = p.getString("ps");
        userManageDao.addPower(name,ps);
        return  null;
    }

    public JSONObject powerManageDel(String request){
        val p = Objects.requireNonNull(JSON.parseObject(request));
        String  det = Objects.requireNonNull(p.getString("detail"));
        userManageDao.delPower(det);
        return null;
    }

}
