package com.kafka.consumer.model.dto;

import lombok.*;

import java.util.List;

public class NaverSmsDto {

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SmsBody{
        private String type;
        private String from;
        private String subject;
        private String content;
        private List<SmsMessage> messages;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class SmsMessage{
        private String to;
    }
}