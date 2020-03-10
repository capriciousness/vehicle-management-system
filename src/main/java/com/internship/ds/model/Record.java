package com.internship.ds.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Record {
    private Integer id;
    private String vehicleId;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date departDate;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date backDate;
    private String level;
    private String event;
    private Integer status1;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date realDepartDate;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date realBackDate;
    private Integer status2;
    private String timeout;
    private String username;
    private String name;

}
