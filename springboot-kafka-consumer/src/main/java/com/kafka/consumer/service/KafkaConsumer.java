package com.kafka.consumer.service;

import com.kafka.consumer.domain.enums.EErrorActionType;
import com.kafka.consumer.domain.enums.ESmsType;
import com.kafka.consumer.exception.ErrorCode;
import com.kafka.consumer.exception.ServerException;
import com.kafka.consumer.model.request.SmsRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final SmsService smsService;

    @KafkaListener(
            topics = "test",
            groupId = "test-sns"
    )
    public void testListen(String msg){
        log.info("get message ::: " + msg);
    }

    @KafkaListener(
            topics = "sms",
            groupId = "test-sns"
    )
    public void smsListen(String request){
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject data = (JSONObject) jsonParser.parse(request);

            String type = (String) data.get("smsType");
            ESmsType smsType = ESmsType.INVITE;
            if(type.equals("INVITE")){
                smsType = ESmsType.INVITE;
            }

            SmsRequest.SmsRegular regular = new SmsRequest.SmsRegular();
            regular.setSmsType(smsType);
            regular.setUserTel((String) data.get("userTel"));

            smsService.sendSms(regular);
        } catch (Exception e) {
            throw new ServerException(ErrorCode.SMS_SEND_FAIL, EErrorActionType.RETRY, "발송 오류");
        }
    }

}
