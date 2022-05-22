package com.kafka.consumer.service;

import com.kafka.consumer.api.NaverSmsApi;
import com.kafka.consumer.common.Constants;
import com.kafka.consumer.common.SmsContent;
import com.kafka.consumer.domain.enums.EErrorActionType;
import com.kafka.consumer.domain.enums.ESmsType;
import com.kafka.consumer.exception.ErrorCode;
import com.kafka.consumer.exception.ServerException;
import com.kafka.consumer.model.dto.NaverSmsDto;
import com.kafka.consumer.model.request.SmsRequest;
import com.kafka.consumer.model.response.NaverSmsResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.List;

@Service
@RefreshScope
@Slf4j
@RequiredArgsConstructor
public class SmsService {

    private final NaverSmsApi naverSmsApi;

    @Value("${naver.api.access-key}")
    private String NAVER_ACCESS_KEY;
    @Value("${naver.api.secret-key}")
    private String NAVER_SECRET_KEY;

    public void sendSms(SmsRequest.SmsRegular request) {

        List<NaverSmsDto.SmsMessage> list = new ArrayList<>();
        list.add(new NaverSmsDto.SmsMessage(request.getUserTel()));

        String subject = "";
        String content = "";
        String type = "";

        if (request.getSmsType().equals(ESmsType.INVITE)) {
            type = SmsContent.TEST_INVITE_TYPE;
            subject = "테스트 제목";
            content = "테스트 내용";
        } else if (request.getSmsType().equals(ESmsType.INSTALL)) {
            type = SmsContent.TEST_INSTALL_TYPE;
            subject = SmsContent.TEST_INSTALL_SUBJECT;
            content = SmsContent.TEST_INSTALL_CONTENT;
        } else {
            throw new ServerException(ErrorCode.INVALID_PARAMETER, EErrorActionType.RETRY, "파라미터 오류");
        }

        NaverSmsDto.SmsBody body = NaverSmsDto.SmsBody.builder()
                .type(type)
                .from(Constants.NAVER_SMS_FROM)
                .subject(subject)
                .content(content)
                .messages(list)
                .build();

        sendMessage(body);
    }

    private boolean sendMessage(NaverSmsDto.SmsBody body){
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String signature = makeSignature(timeStamp);

        NaverSmsResponse naverSmsResponse = naverSmsApi.sendSms(timeStamp, NAVER_ACCESS_KEY, signature, body);

        if(!naverSmsResponse.getStatusName().equals("success")){
            throw new ServerException(ErrorCode.SMS_SEND_FAIL, EErrorActionType.RETRY, "메세지 전송 오류");
        }
        return true;
    }

    private String makeSignature(String timeStamp) {

        String space = " ";
        String newLine = "\n";
        String method = "POST";

        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(Constants.NAVER_SMS_URL)
                .append(newLine)
                .append(timeStamp)
                .append(newLine)
                .append(NAVER_ACCESS_KEY)
                .toString();

        String encode = "";
        try {
            SecretKeySpec signingKey = new SecretKeySpec(NAVER_SECRET_KEY.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            encode = Base64.encodeBase64String(rawHmac);
        } catch (Exception e) {
            throw new ServerException(ErrorCode.SMS_SEND_FAIL, EErrorActionType.RETRY, "메세지 전송 오류");
        }

        return encode;
    }
}
