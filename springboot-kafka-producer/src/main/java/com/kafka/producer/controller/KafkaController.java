package com.kafka.producer.controller;

import com.kafka.producer.model.request.SmsRequest;
import com.kafka.producer.model.response.ServerResponse;
import com.kafka.producer.service.KafkaProducer;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProducer kafkaConsumer;

    @PostMapping
    @ApiOperation(value = "kafka sms 보내기")
    public ServerResponse sendSmsMessage(@RequestBody SmsRequest.SmsRegular request) {
        kafkaConsumer.sendSmsMessage(request);
        return new ServerResponse();
    }

    @GetMapping
    @ApiOperation(value = "kafka test message")
    public ServerResponse sendTestMessage(){
        kafkaConsumer.sendTestTopicMessage();
        return new ServerResponse();
    }
}
