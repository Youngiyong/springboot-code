package com.spring.sqs.service;

import com.spring.sqs.model.request.SmsRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;


@Slf4j
@Service
@RequiredArgsConstructor
public class SqsConsumer {

    private final String SQS_TOPIC_SNS = "test_sns";
    private final String SQS_TOPIC_PUSH = "test_push";


    @SqsListener(value = SQS_TOPIC_SNS, deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receiveMessage(@Payload SmsRequest.SmsRegular payload, @Headers Map<String, String> headers) {
        log.info("message received {} {}", payload, headers);
    }

    @SqsListener(value = SQS_TOPIC_PUSH, deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receivePush(@Payload String payload, @Headers Map<String, String> headers) {
        log.info("message received {} {}", payload, headers);
    }
}
