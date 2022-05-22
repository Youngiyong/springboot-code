package com.kafka.producer.exception;


import com.kafka.producer.domain.enums.EErrorActionType;

public class ServerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    private EErrorActionType type;

    public ServerException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServerException(ErrorCode errorCode, EErrorActionType type, String message) {
        super(message);
        this.errorCode = errorCode;
        this.type = type;
    }


    public ServerException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ServerException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ServerException(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }


    public ErrorCode getErrorCode() {
        return errorCode ;
    }

    public EErrorActionType getType() { return type; }
}