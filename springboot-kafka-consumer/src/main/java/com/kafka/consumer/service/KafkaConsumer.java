package com.kafka.consumer.service;

import com.kafka.consumer.model.request.SmsRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(
            topics = "test",
            groupId = "test-sns"
    )
    public void testListen(String msg){
        log.info("get message ::: " + msg);
    }
}
