package com.spring.serviceapi.service;

import com.spring.serviceapi.feign.ApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApiService {

    private final ApiClient apiClient;

    public ApiService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public String checkPayPoint(String point){

        String result = "";
        try {
            result = apiClient.checkPay("api", point);
        } catch (Exception e) {
            log.error("error ::: " + e.getMessage());
            return "error";
        }
        return  result;
    }
}
