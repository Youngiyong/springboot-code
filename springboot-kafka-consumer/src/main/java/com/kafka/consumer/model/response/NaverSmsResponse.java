package com.kafka.consumer.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NaverSmsResponse {
    private String requestId;
    private String statusCode;
    private String statusName;
    private Timestamp requestTime;
}
