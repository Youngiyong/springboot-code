package com.service.contents.dto;

import lombok.*;

import java.util.UUID;

public class ResponseDto {


    @Getter
    @AllArgsConstructor
    public static class ResponseCreate {
        private UUID id;
        private int returnCode;
        private String returnMessage;
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
        private int returnCode;
        private String returnMessage;
    }
}


