package com.spring.serviceapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class ConfigService {

    @Value("${say.hello}")
    private String greeting;

    public String greeting(){
        System.out.println(greeting);
        return greeting;
    }

}
