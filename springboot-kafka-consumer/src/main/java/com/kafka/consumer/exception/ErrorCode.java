package com.kafka.consumer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ErrorCode {

    //200
    SUCCESS(200,  "B0000"),

    SIGNUP(200, "B2001"),
    UPDATE(200, "B2002"),

    //400
    INVALID_PARAMETER(400, "B4000"),

    //500
    INTERNAL_SERVER_ERROR_CONVERT_CODE(500, "B5000"),
    INTERNAL_SERVER_ERROR(500, "B5000");

    @Getter private final int status;
    @Getter private final String code;
}