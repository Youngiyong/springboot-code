package com.spring.serviceapi.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApiClientFallback implements FallbackFactory<ApiClient> {

    @Override
    public ApiClient create(Throwable cause) {

        return new ApiClient() {
            @Override
            public String checkPay(String route, String checkPoint) {
                log.error(cause.toString());
                return "Response Error";
            }
        };
    }
}
