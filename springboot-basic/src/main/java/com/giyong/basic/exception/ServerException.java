package com.cheese.auth.exception;

import com.cheese.auth.model.response.ErrorResponse;
import com.cheese.domain.enums.EErrorActionType;

public class AuthServerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    private EErrorActionType type;

    public AuthServerException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public AuthServerException(ErrorCode errorCode, EErrorActionType type, String message) {
        super(message);
        this.errorCode = errorCode;
        this.type = type;
    }


    public AuthServerException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public AuthServerException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public AuthServerException(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }


    public ErrorCode getErrorCode() {
        return errorCode ;
    }

    public EErrorActionType getType() { return type; }
}