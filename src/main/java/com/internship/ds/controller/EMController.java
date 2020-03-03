package com.internship.ds.controller;

import com.alibaba.fastjson.JSONObject;
import com.internship.ds.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;

import static com.internship.ds.controller.EMController.CAR_ZC;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(CAR_ZC)
public class EMController {

    @RequestMapping(value = CAR_STAFF_LOGIN , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> login(ServletRequest servletRequest, @RequestBody String request){
        return ResponseEntity.status(200).body(loginService.login(servletRequest,request));
    }

    public static final String CAR_ZC = "/zccar";
    public static final String CAR_STAFF_LOGIN = "/staff/login";

    @Autowired
    private LoginService loginService;
}
