package com.cheese.auth.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ErrorCode {
    // TODO: Need to refine

    //200
    SUCCESS(200,  "A0000"),
    USER_LOGIN(200, "A2001"),
    USER_LOGIN_AUTO(200, "A2002"),
    USER_REFRESH(200, "A2003"),

    USER_DANAL_AUTH_CHECK(200, "A2004"),
    USER_DANAL_AUTH_HEALTH_CHECK(200, "A2005"),
    USER_DANAL_CERTIFICATION_CALLBACK(200, "A2006"),
    USER_PARSE_CLAIMS(401, "A2007"),

    PARTNER_SIGNUP(200, "A2101"),
    PARTNER_LOGIN(200, "A2102"),
    PARTNER_REFRESH(200, "A2103"),
    PARTNER_LOGOUT(200, "A2104"),
    PARTNER_NOT_AUTHORITY(200, "A2105"),
    PARTNER_PARSE_CLAIMS(200, "A2106"),



    //400
    INVALID_PARAMETER(400, "A4000"),
    //500
    INTERNAL_SERVER_ERROR(500, "A5000");

    @Getter private final int status;
    @Getter private final String code;
}