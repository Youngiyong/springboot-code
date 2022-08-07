package com.example.demo.controller;


import com.example.demo.api.RestApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RootController {

    private final RestApi restApi;

    @GetMapping
    public String root(){
        return "OK";
    }

    @GetMapping("/test")
    public String test(){
        log.info("=================start=================");
        String message =  restApi.check();
        log.info("=================end===================");
        return message;
    }

}
