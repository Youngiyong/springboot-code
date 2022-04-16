package com.spring.serviceapi.controller;

import com.spring.serviceapi.service.ConfigService;
import com.spring.serviceapi.service.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MobileController {

    private ApiService apiService;
    private ConfigService configService;

    @GetMapping("/hello")
    public String getHello(@RequestHeader("Auth-header") String header){

        System.out.println("header ::: " + header);
        return "hello world";
    }

    @GetMapping("/bye")
    public String getBye(){
        return apiService.checkPayPoint("bye bye");
    }

    @GetMapping("/config")
    public String greeting(){
        return configService.greeting();
    }
}
