package com.domain.practice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ExceptionCode {
    NOT_FOUND_ENUM_CODE(500, "D4400", "상태 코드가 존재하지 않습니다.");

    @Getter private final int status;
    @Getter private final String code;
    @Getter private final String message;


}
