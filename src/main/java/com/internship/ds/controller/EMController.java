package com.internship.ds.controller;

import com.alibaba.fastjson.JSONObject;
import com.internship.ds.model.User;
import com.internship.ds.service.LoginService;
import com.internship.ds.service.RecordService;
import com.internship.ds.service.RegisterService;
import com.internship.ds.service.UserManageService;
import com.internship.ds.service.VehicleInfoManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.util.List;

import static com.internship.ds.controller.EMController.CAR_ZC;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(CAR_ZC)
public class EMController {

    @RequestMapping(value = CAR_STAFF_LOGIN , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> login(ServletRequest servletRequest, @RequestBody String request){
        return ResponseEntity.status(200).body(loginService.login(servletRequest,request));
    }

    @RequestMapping(value = CAR_USERBASE_UPDATE , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> userManage(@RequestBody String request){
        return ResponseEntity.status(200).body(userManageService.userManage(request));
    }

    @RequestMapping(value = CAR_USERBASE_SEARCH , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> findUserBase(@RequestBody String request){
        return ResponseEntity.status(200).body(userManageService.findUserBase(request));
    }

    @RequestMapping(value = CAR_USERROLE_ADD , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> roleManageadd(@RequestBody String request){
        return ResponseEntity.status(200).body(userManageService.roleManageadd(request));
    }

    @RequestMapping(value = CAR_USERROLE_DEL , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> roleManagedel(@RequestBody String request){
        return ResponseEntity.status(200).body(userManageService.roleManagedel(request));
    }

    @RequestMapping(value = CAR_USERPOWER_DEL , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> powerManage(@RequestBody String request){
        return ResponseEntity.status(200).body(userManageService.powerManageDel(request));
    }

    @RequestMapping(value = CAR_USERPOWER_ADD , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> findUserPower(@RequestBody String request){
        return ResponseEntity.status(200).body(userManageService.powerManageAdd(request));
    }

    @RequestMapping(value = CAR_VEHICLE_INSERTINFO , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> addCarInfo(@RequestBody String request){
        return ResponseEntity.status(200).body(vehicleInfoManageService.addCarInfo(request));
    }

    @RequestMapping(value = CAR_VEHICLE_CHANGE , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> updateCar(@RequestBody String request){
        return ResponseEntity.status(200).body(vehicleInfoManageService.updateCarInfo(request));
    }

    @RequestMapping(value = CAR_VEHICLE_SEARCH , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> carSearch(@RequestBody String request){
        return ResponseEntity.status(200).body(vehicleInfoManageService.findCarInfo(request));
    }

    @RequestMapping(value = CAR_VEHICLE_DELINFO , method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> delCar(@RequestBody String request){
        return ResponseEntity.status(200).body(vehicleInfoManageService.delCarInfo(request));
    }


    /**
     * 用户登录
     * @param request
     * @param servletRequest
     * @return
     */
    @RequestMapping(value = CAR_STAFF_LOGIN ,method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> login(@RequestBody String request, ServletRequest servletRequest){
        return ResponseEntity.status(200).body(loginService.login(servletRequest,request));
    }

    /**
     * 用户注册
     * @param request
     * @param servletRequest
     * @return
     */
    @RequestMapping(value = CAR_STAFF_REGISTER ,method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> register(@RequestBody String request, ServletRequest servletRequest){
        return ResponseEntity.status(200).body(registerService.register(servletRequest,request));
    }

    /**
     * 用户申请用车
     * @param request
     * @param servletRequest
     * @return
     */
    @RequestMapping(value = CAR_RECORD_U_APPLICATION ,method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public String application(@RequestBody String request, ServletRequest servletRequest){
        recordService.application(request, servletRequest);
        return  null;
        //return "redirect:http://localhost:10010/zccar/record/xxx.html";
    }

    /**
     * 用户查询自己使用记录
     * @param servletRequest
     * @return
     */
    @RequestMapping(value = CAR_RECORD_U_SEARCH,method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> uRecordSearch (ServletRequest servletRequest){
        return ResponseEntity.status(200).body(recordService.usearch(servletRequest));
    }
    /**
     * 车辆管理员查询全部或待审核记录
     * @param request
     * @param servletRequest
     * @return
     */
    @RequestMapping(value = CAR_RECORD_A_SEARCH ,method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JSONObject> aRecordSearch(@RequestBody String request, ServletRequest servletRequest){
        return ResponseEntity.status(200).body(recordService.asearch(request, servletRequest));
    }
    /**
     * 车辆管理员修改审核状态及其他信息
     * @param request
     * @param servletRequest
     * @return
     */
    @RequestMapping(value = CAR_RECORD_A_UPDATE ,method = POST , produces = APPLICATION_JSON_UTF8_VALUE)
    public String updateRecord(@RequestBody String request, ServletRequest servletRequest){
        recordService.updateRecord(servletRequest,request);
        return  null;
        //return "redirect:http://localhost:10010/zccar/record/xxx.html";
    }

    public static final String CAR_ZC = "/zccar";
    public static final String CAR_STAFF_LOGIN = "/staff/login";
    public static final String CAR_USERBASE_UPDATE = "/userbase/update";
    public static final String CAR_USERBASE_SEARCH = "/userbase/search";
    public static final String CAR_USERROLE_ADD = "/userrole/add";
    public static final String CAR_USERROLE_DEL = "/userrole/del";
    public static final String CAR_USERPOWER_ADD = "/userpower/add";
    public static final String CAR_USERPOWER_DEL = "/userpower/del";
    public static final String CAR_VEHICLE_INSERTINFO = "/vehicle/insertinfo";
    public static final String CAR_VEHICLE_CHANGE = "/vehicle/change";
    public static final String CAR_VEHICLE_SEARCH = "/vehicle/search";
    public static final String CAR_VEHICLE_DELINFO = "/vehicle/delinfo";
    public static final String CAR_STAFF_REGISTER = "/staff/register";
    public static final String CAR_RECORD_U_APPLICATION = "/record/application";
    public static final String CAR_RECORD_U_SEARCH = "/record/usearch";
    public static final String CAR_RECORD_A_UPDATE = "/record/updateRecord";
    public static final String CAR_RECORD_A_SEARCH = "/record/asearch";

    @Autowired
    private LoginService loginService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private UserManageService userManageService;
    @Autowired
    private VehicleInfoManageService vehicleInfoManageService;


}
