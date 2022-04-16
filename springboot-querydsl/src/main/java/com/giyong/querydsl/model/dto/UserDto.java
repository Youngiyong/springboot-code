package com.giyong.querydsl.model.dto;

import com.giyong.querydsl.domain.enums.EUserGradeFlag;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

public class UserDto {

    @Setter
    @Getter
    public static class User {

        @ApiModelProperty(value = "유저 PK", example = "1", dataType = "java.lang.Long")
        private Long id;

        @ApiModelProperty(value = "이름", example = "윤기용", dataType = "java.lang.String")
        private String name;

        @ApiModelProperty(value = "휴대폰번호", example = "01092069357", dataType = "java.lang.String")
        private String tel;

        @ApiModelProperty(value = "url", example = "https://giyongbucket.s3.ap-northeast-2.amazonaws.com/users/1/8d5e0c89-92da-4e5d-8d83-9274aaf627e5.jpeg", dataType = "java.lang.String")
        private String thumbnail;

        private EUserGradeFlag grade;

        private ZonedDateTime createDate;
    }

}
