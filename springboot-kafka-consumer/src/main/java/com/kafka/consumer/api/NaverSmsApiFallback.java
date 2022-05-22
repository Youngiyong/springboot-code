package com.kafka.consumer.api;

import com.kafka.consumer.model.dto.NaverSmsDto;
import com.kafka.consumer.model.response.NaverSmsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NaverSmsApiFallback implements FallbackFactory<NaverSmsApi> {

    @Override
    public NaverSmsApi create(Throwable cause) {

        return new NaverSmsApi() {
            @Override
            public NaverSmsResponse sendSms(String timsstamp, String accessKey, String signature, NaverSmsDto.SmsBody smsBody) {
                log.info(cause.getMessage());
                return null;
            }
        };
    }
}