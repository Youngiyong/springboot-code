package com.kafka.producer.controller;

import com.kafka.producer.model.request.SmsRequest;
import com.kafka.producer.service.KafkaProducer;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    @ApiOperation(value = "kafka sms 보내기")
    public String sendMessage(@RequestBody SmsRequest.SmsRegular request) {
        this.kafkaProducer.sendMessage(request);
        return "success";
    }
}
