package com.cheese.auth.advice;

import com.cheese.auth.exception.ErrorCode;
import com.cheese.auth.exception.InvalidParameterException;
import com.cheese.auth.exception.AuthServerException;
import com.cheese.auth.model.response.AuthServerResponse;
import com.cheese.auth.model.response.ErrorResponse;
import com.cheese.domain.enums.EErrorActionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(InvalidParameterException.class)
    protected ResponseEntity<ErrorResponse> handleInvalidParameterException(InvalidParameterException e) {
        log.error("handleInvalidParameterException", e);

        ErrorResponse response = ErrorResponse
                .builder()
                .type(e.getType())
                .code(e.getErrorCode().getCode())
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthServerException.class)
    protected ResponseEntity<AuthServerResponse> handleCustomException(AuthServerException e) {
        log.error("handleUserAuthServerExcepiton", e);

        ErrorResponse response = ErrorResponse
                .builder()
                .type(e.getType())
                .message(e.getMessage())
                .code(e.getErrorCode().getCode())
                .build();

        return new ResponseEntity<>(new AuthServerResponse(response), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("handleException", e);

        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        ErrorResponse response = ErrorResponse
                .builder()
                .type(EErrorActionType.RETRY)
                .code(errorCode.getCode())
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}