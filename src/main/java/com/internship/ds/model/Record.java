package com.internship.ds.model;

import lombok.Data;

import java.util.Date;

@Data
public class Record {
    private Integer id;
    private String vehicleId;
    private Date departDate;
    private Date backDate;
    private String level;
    private String event;
    private Integer status1;
    private Date realDepartDate;
    private Date realBackDate;
    private Integer status2;
    private String timeout;
    private String username;
    private String name;

}
