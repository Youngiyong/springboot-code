package com.cheese.api.model.dto;

import com.cheese.domain.enums.user.EUserGradeFlag;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

public class UserDto {

    @Setter
    @Getter
    public static class User {

        @ApiModelProperty(value = "유저 PK", example = "1", dataType = "java.lang.Long")
        private Long id;    // internal

        @ApiModelProperty(value = "이름", example = "윤기용", dataType = "java.lang.String")
        private String name;

        @ApiModelProperty(value = "휴대폰번호", example = "01092069357", dataType = "java.lang.String")
        private String tel;

        @ApiModelProperty(value = "url", example = "        https://giyongbucket.s3.ap-northeast-2.amazonaws.com/users/1/8d5e0c89-92da-4e5d-8d83-9274aaf627e5.jpeg", dataType = "java.lang.String")
        private String thumbnail;

        @ApiModelProperty(value = "등급(BRONZE:브론즈, SILVER:실버, GOLD:골드)", example = "BRONZE")
        private EUserGradeFlag grade;

        @ApiModelProperty(value = "치즈포인트", example = "10000", dataType = "java.lang.Integer")
        private Integer cheesePoint;

        @ApiModelProperty(value = "결제 알림 여부", example = "true", dataType = "java.lang.Boolean")
        private Boolean isAlertPay;

        @ApiModelProperty(value = "프로모션 이벤트 알림 여부", example = "true", dataType = "java.lang.Boolean")
        private Boolean isAlertPromotion;

        @ApiModelProperty(value = "푸시 알림 여부", example = "true", dataType = "java.lang.Boolean")
        private Boolean isAlertPush;

        @ApiModelProperty(value = "생체 정보 동의 여부", example = "true", dataType = "java.lang.Boolean")
        private Boolean isFingerprint;

        @ApiModelProperty(value = "위치 정보 동의 여부", example = "true", dataType = "java.lang.Boolean")
        private Boolean isLocation;

        @ApiModelProperty(value = "현재 앱에 푸쉬받은 알람 여부", example = "false", dataType = "java.lang.Boolean")
        private Boolean isAlarm;
    }

    @Getter
    @Setter
    public static class UserPoint {
        @ApiModelProperty(value = "이름", example = "윤기용", dataType = "java.lang.String")
        private String name;
        @ApiModelProperty(value = "치즈포인트", example = "10000", dataType = "java.lang.Integer")
        private Integer cheesePoint;
    }
}
