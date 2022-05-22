package com.kafka.consumer.service;
import com.kafka.consumer.domain.enums.ESmsType;
import com.kafka.consumer.model.request.SmsRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = "spring.profiles.active:dev")
@Transactional
class SmsServiceTest {

    @Autowired
    private SmsService smsService;

    @Test
    public void sms(){
        SmsRequest.SmsRegular request = new SmsRequest.SmsRegular();
        request.setUserTel("01092069357");
        request.setSmsType(ESmsType.INSTALL);
//        smsService.sendSms(request);
    }
}