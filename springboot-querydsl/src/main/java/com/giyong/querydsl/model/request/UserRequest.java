package com.giyong.querydsl.model.request;

import com.giyong.querydsl.domain.enums.EUserGradeFlag;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

public class UserRequest {


    @Getter
    public static class UserSign {

        @NotNull(message = "이름을 입력해주세요.")
        @ApiModelProperty(value = "이름", example = "윤기용", dataType = "java.lang.String")
        private String name;

        @NotNull(message = "휴대폰 번호를 입력해주세요.")
        @ApiModelProperty(value = "휴대폰번호", example = "01092069357", dataType = "java.lang.String")
        private String tel;

        @ApiModelProperty(value = "url", example = "https://giyongbucket.s3.ap-northeast-2.amazonaws.com/users/1/8d5e0c89-92da-4e5d-8d83-9274aaf627e5.jpeg", dataType = "java.lang.String")
        private String thumbnail;

        private EUserGradeFlag grade;
    }

    @Getter
    public static class UserUpdate {
        private String name;
        private String thumbnail;
        private String tel;
        private Boolean isAlertPush;
    }
}
