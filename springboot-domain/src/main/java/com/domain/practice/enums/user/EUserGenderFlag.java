package com.domain.practice.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum EUserGenderFlag {
    MAN("남성", "M"),
    WOMEN( "여성", "W");

    private String description;
    private String code;

    public static EUserGenderFlag ofCode(String code){

        return Arrays.stream(EUserGenderFlag.values())
                .filter(v -> v.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new ConvertException(String.format("상태코드에 code=[%s]가 존재하지 않습니다.", code)));
    }
}
