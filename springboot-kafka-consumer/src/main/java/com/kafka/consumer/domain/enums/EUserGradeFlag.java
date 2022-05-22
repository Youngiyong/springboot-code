package com.kafka.consumer.domain.enums;

import com.kafka.consumer.exception.ErrorCode;
import com.kafka.consumer.exception.ServerException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum EUserGradeFlag {
    BRONZE("브론즈", "B"),
    SILVER("실버", "S"),
    GOLD( "골드", "G");

    private String description;
    private String code;

    public static EUserGradeFlag ofCode(String code){

        return Arrays.stream(EUserGradeFlag.values())
                .filter(v -> v.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new ServerException(
                        ErrorCode.INTERNAL_SERVER_ERROR_CONVERT_CODE,
                        EErrorActionType.NONE,
                        String.format("상태코드에 code=[%s]가 존재하지 않습니다.", code)));
    }
}
