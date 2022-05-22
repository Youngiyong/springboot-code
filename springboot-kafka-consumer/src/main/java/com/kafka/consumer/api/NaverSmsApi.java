package com.kafka.consumer.api;


import com.kafka.consumer.common.Constants;
import com.kafka.consumer.model.dto.NaverSmsDto;
import com.kafka.consumer.model.response.NaverSmsResponse;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RefreshScope
@FeignClient(name = "naver-sms-api",
        url = "${naver.sms.url}",
        fallbackFactory = NaverSmsApiFallback.class)
public interface NaverSmsApi {

    @RequestMapping(method = RequestMethod.POST,
            value = Constants.NAVER_SMS_URL,
            produces = "application/json")
    NaverSmsResponse sendSms(@RequestHeader("x-ncp-apigw-timestamp") String timsstamp,
                             @RequestHeader("x-ncp-iam-access-key") String accessKey,
                             @RequestHeader("x-ncp-apigw-signature-v2") String signature,
                             NaverSmsDto.SmsBody smsBody);
}