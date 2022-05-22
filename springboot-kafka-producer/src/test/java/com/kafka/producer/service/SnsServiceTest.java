//package com.kafka.producer.service;
//
//import com.kafka.producer.domain.enums.ESmsType;
//import com.kafka.producer.model.request.SmsRequest;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.transaction.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(properties = "spring.profiles.active:dev")
//@Transactional
//class SmsServiceTest {
//
//    @Autowired
//    private SmsService smsService;
//
//    @Test
//    public void sms(){
//        SmsRequest.SmsRegular request = new SmsRequest.SmsRegular();
//        request.setUserTel("01032255078");
//        request.setSmsType(ESmsType.INVITE);
////        smsService.sendSms(request);
//    }
//}