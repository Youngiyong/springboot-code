package com.cheese.api.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class UserRequest {

    @Getter
    public static class UserSign {
        private DeviceRequest.DeviceSign device;

        @Size(min = 64, max=64, message = "유효하지 않는 키값입니다.")
        @NotNull(message = "인증키값은 필수값입니다.")
        @ApiModelProperty(value = "인증키", example = "e49b85c62d5f56617ea2460434e877bdf1f02fdd81d897d98017c7924427df4c", dataType = "java.lang.String")
        private String secret;

//        @ApiModelProperty(required = true, example = "[ 1, 2 ]")
//        private List<Long> agree;
//
//        @ApiModelProperty(required = true, example = "[ 3 ]")
//        private List<Long> disAgree;
    }
    @Getter
    public static class UserLogin {
        private DeviceRequest.DeviceSign device;

        @Size(min = 64, max=64, message = "유효하지 않는 키값입니다.")
        @NotNull(message = "인증키값은 필수값입니다.")
        @ApiModelProperty(value = "인증키", example = "76e49a8ef64be2c43d7dae1c501e769814d56e5e928d5fdc4bf2ac44095fa8a7", dataType = "java.lang.String")
        private String secret;
    }

    @Getter
    public static class UserSampleLogin {
        @ApiModelProperty(value = "유저 PK", example = "1", dataType = "java.lang.Long")
        private Long userId;
    }

    @Getter
    public static class UserPaymentNumberUpdateRequest {
        @NotNull(message = "결제 비밀번호는 NULL일수 없습니다.")
        @Size(min = 6, max = 6)
        @Pattern(regexp="(^$|[0-9]{6})")
        @ApiModelProperty(required = true, value = "결제비밀번호", example = "123456", dataType = "java.lang.String")
        private String paymentNumber;
    }


    @Getter
    public static class UserUpdateRequest {
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
    }
}
