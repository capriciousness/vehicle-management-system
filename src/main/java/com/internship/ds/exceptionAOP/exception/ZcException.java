package com.internship.ds.exceptionAOP.exception;

import com.internship.ds.exceptionAOP.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ZcException extends RuntimeException {

    private ExceptionEnums exceptionEnums;

}
