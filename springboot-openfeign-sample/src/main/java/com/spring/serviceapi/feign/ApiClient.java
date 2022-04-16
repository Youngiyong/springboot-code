package com.spring.serviceapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "test-api",
        url = "${test.api.url}",
        fallbackFactory = ApiClientFallback.class)
public interface ApiClient {

    @RequestMapping(method = RequestMethod.GET,
            value = "/check",
            produces = "application/json")
    String checkPay(@RequestHeader("Route-check") String route,
                    @RequestParam(name = "checkPoint") String checkPoint);
}
