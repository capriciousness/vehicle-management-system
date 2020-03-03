package com.internship.ds.exceptionAOP.vo;

import com.internship.ds.exceptionAOP.enums.ExceptionEnums;
import lombok.Data;

@Data
public class ExceptionResult {
    private int errorCode;
    private String error;

    public ExceptionResult(ExceptionEnums em){
        this.errorCode = em.getErrorCode();
        this.error = em.getError();
    }

}
