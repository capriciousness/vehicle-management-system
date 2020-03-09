package com.internship.ds.controller;

import com.alibaba.fastjson.JSONObject;
import com.internship.ds.model.User;
import com.internship.ds.service.LoginService;
import com.internship.ds.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;

import static com.internship.ds.controller.EMController.CAR_ZC;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(CAR_ZC)
public class EMController {
    public static final String CAR_ZC = "/zccar";
    public static final String CAR_STAFF_LOGIN = "/staff/login";
    public static final String CAR_STAFF_REGISTER = "/staff/register";

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = CAR_STAFF_LOGIN ,method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> login(@RequestBody String request, ServletRequest servletRequest){
        return ResponseEntity.status(200).body(loginService.login(servletRequest,request));
    }

    @Autowired
    private RegisterService registerService;
    @RequestMapping(value = CAR_STAFF_REGISTER ,method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> register(@RequestBody String request, ServletRequest servletRequest){
        return ResponseEntity.status(200).body(registerService.register(servletRequest,request));
    }


}
