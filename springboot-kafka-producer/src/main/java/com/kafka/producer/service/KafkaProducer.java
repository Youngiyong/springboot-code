package com.kafka.producer.service;

import com.kafka.producer.model.request.SmsRequest;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private static final String TOPIC = "sns";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(SmsRequest.SmsRegular request){
        JSONObject jobj = new JSONObject();
        jobj.put("smsType", request.getSmsType().name());
        jobj.put("userTel", request.getUserTel());
        this.kafkaTemplate.send(TOPIC, jobj.toJSONString());
    }
}
