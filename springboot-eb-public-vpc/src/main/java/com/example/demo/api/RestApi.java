package com.example.demo.api;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "rest-api",
        url = "https://dev.cheesepoint.kr"
//        url = "localhost:8200"
)
public interface RestApi {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String check();
}
