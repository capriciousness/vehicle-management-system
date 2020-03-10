package com.internship.ds.exceptionAOP.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum  ExceptionEnums {

    UNIMPLEMENTED(1, "Not yet implemented."),
    UNEXPECTED(2, "Unexpected error."),
    REGISTER_FAILED(3, "Register failed."),
    FORMAT_CORRUPTED(4, "Format corrupted."),
    NOT_FOUND(5, "Not found."),
    INCORRECT_STATE(6, "Incorrect state."),
    RESTRICTED(7, "Operation is not allowed."),
    CANCELLED(8, "Operation has been cancelled."),
    NOTALLOWED(9, "not allowed."),
    CONFLICT(10, "Conflicts detected."),
    UNSUPPORTED(11, "Operation is not supported."),
    NOT_LOGGED_IN(12, "Not logged in."),
    UNDEFINED(Integer.MAX_VALUE, "Undefined error.");

    @Getter private int errorCode;
    @Getter private String error;
}
