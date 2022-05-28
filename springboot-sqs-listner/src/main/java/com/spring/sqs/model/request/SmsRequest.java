package com.spring.sqs.model.request;

import com.spring.sqs.enums.ESmsType;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

public class SmsRequest {

    @Getter
    @Setter
    public static class SmsCustom {
        @ApiModelProperty(value = "사용자 연락처", example = "01012341234", required = true, dataType = "java.lang.String")
        private String userTel;
        @ApiModelProperty(value = "메세지 타입", example = "SMS,LMS", required = true, dataType = "java.lang.String")
        private String messageType;
        @ApiModelProperty(value = "메세지 제목", example = "제목제목", required = true, dataType = "java.lang.String")
        private String subject;
        @ApiModelProperty(value = "메세지 내용", example = "보낼 내용", required = true, dataType = "java.lang.String")
        private String content;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SmsRegular {
        private String userTel;
        private ESmsType smsType;
    }
}
