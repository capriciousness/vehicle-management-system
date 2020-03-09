package com.internship.ds.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.internship.ds.dao.RecordDao;
import com.internship.ds.model.Record;
import com.internship.ds.model.User;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Service
public class RecordService {
    @Autowired
    private RecordDao recordDao;

    public JSONObject application(ServletRequest servletRequest, String request) {
        val p = Objects.requireNonNull(JSON.parseObject(request));
        JSONObject json = Objects.requireNonNull(p.getJSONObject("record"));
        Record record = JSONObject.toJavaObject(json, Record.class);
        recordDao.uUpdate(record);
        //跳转到查询结果页面（usearch）
        return null;
    }

    public JSONObject usearch(ServletRequest servletRequest) {
        val httpRequest = (HttpServletRequest)servletRequest;
        val session = httpRequest.getSession(true);

        String username = (String)session.getAttribute("username");
        recordDao.uSearch(username);
        return null;
    }

    public JSONObject asearch(ServletRequest servletRequest, String request) {

        return null;
    }

    public JSONObject updateRecord(ServletRequest servletRequest, String request) {

        return null;
    }
}
